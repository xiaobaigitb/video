package com.zhiyou.video.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SpeakerModel;
import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.query.VideoListQuery;
import com.zhiyou.video.service.ICourseService;
import com.zhiyou.video.service.ISpeakerService;
import com.zhiyou.video.service.IVideoService;
import com.zhiyou.video.validator.VideoAddValidator;
import com.zhiyou.video.validator.VideoEditValidator;

/**
 * Descr:
 *
 */
@Controller
@RequestMapping("/admin/video")
public class VideoController {
	@Autowired
	IVideoService videoService;
	@Autowired
	ICourseService courseService;
	@Autowired
	ISpeakerService speakerService;
	
	@RequestMapping("index.do")
	public String index(@ModelAttribute("query") VideoListQuery query,Model model){
		List<VideoModel> results = videoService.queryVideoModels(query);
		model.addAttribute("results", results);
		
		//把公用的信息单独写一个方法
		querys(model);
				
		return "admin/video/index";
	}
	
	@RequestMapping(value="add.do",method=RequestMethod.GET)
	public String addGet(Model model){
		querys(model);
		
		return "admin/video/saveOrUpdate";
	}
	
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public String addPost(@Validated(value={VideoAddValidator.class}) VideoModel model,BindingResult result,Model mo){
		System.out.println("binding result："+result);
		
		if(result.hasErrors()){
			mo.addAttribute("message", result.getAllErrors());
			querys(mo);
			return "admin/video/saveOrUpdate";
		}
		
		return saveOrUpdate(model);
	}
	
	@RequestMapping(value="edit.do",method=RequestMethod.GET)
	public String editGet(int id,Model model){
		querys(model);
		VideoModel video = videoService.queryVideoById(id);
		model.addAttribute("video", video);
		return "admin/video/saveOrUpdate";
	}
	
	@RequestMapping(value="edit.do",method=RequestMethod.POST)
	public String editPost(@Validated(value={VideoEditValidator.class}) VideoModel model,BindingResult result,Model mo){
		System.out.println("binding result："+result);
		if(result.hasErrors()){
			mo.addAttribute("message", result.getAllErrors());
			querys(mo);
			//需要将信息查询出来返回
			VideoModel video = videoService.queryVideoById(model.getId());
			mo.addAttribute("video", video);
			return "admin/video/saveOrUpdate";
		}
		return saveOrUpdate(model);
	}
	
	//修改和添加合并在一起
	private String saveOrUpdate(VideoModel model){
		System.out.println("saveOrUpdate得到的信息："+model);
		
		//判断当前请求是添加信息或更新信息
		if(model.getId()>0){
			//更新请求
			model.setUpdateTime(new Date());
			//调用更新方法
			boolean b = videoService.updateVideoModel(model);
			System.out.println("更新视频信息是否成功："+b);
		}else{
			//新增请求
			model.setInsertTime(new Date());
			model.setUpdateTime(new Date());
			//调用新增方法
			int id = videoService.addVideoModel(model);
			System.out.println("新增视频信息，id为"+id);
		}
		
		return "redirect:/admin/video/index.do";
	}
	
	private void querys(Model model){
		//查询条件
		List<SpeakerModel> speakers = speakerService.querySpeakers();
		List<CourseModel> courses = courseService.queryCourseModels();
		
		model.addAttribute("speakers",speakers);
		model.addAttribute("courses",courses);
	}
	
	/**
	 * 改为ajax
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete.do")
	public Map delete(int id){
		boolean b = videoService.deleteById(id);
		//封装结果
		HashMap map = new HashMap();
		if(b){
			//删除成功
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("message", "删除视频信息失败，请重试");
		}
		
		return map;
	}
	
	/**
	 * 批量删除
	 * @return
	 */
	@RequestMapping("batchDelete.do")
	public String batchDelete(int[] checkid){
		System.out.println("批量删除");
		System.out.println(Arrays.toString(checkid));
		return "redirect:/admin/video/index.do";
	}
	
}
