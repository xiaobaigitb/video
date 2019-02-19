package com.zhiyou.video.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.service.ICourseService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE;
import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE_SIZE;

/**
 * 
 * @author Administrator
 * 课程管理功能模块
 */
@Controller
@RequestMapping("/admin/course")
public class CourseController {

	@Autowired
	ICourseService courseService;
	
	/**
	 * 课程列表页面
	 * @return
	 */
	@RequestMapping("index.do")
	public String index(@RequestParam(required = false) Integer pageNum, Model model){
		//根据主讲人名称和主讲人职位查询信息
		HashMap map = new HashMap();
		if (pageNum == null || pageNum < 0) pageNum = DEFAULT_PAGE;
		map.put("pageNum", pageNum);
		map.put("pageSize", DEFAULT_PAGE_SIZE);
		//添加分页相关操作
		PageInfo<CourseModel> list = courseService.queryCoursePageList(map);
		//和上边的index.do用的是同一个页面，所以封装数据的名字也必须一样
		model.addAttribute("pageInfo", list);
		
//		List<CourseModel> results = courseService.queryCourseModels();
//		model.addAttribute("results", results);
		return "admin/course/index";
	}
	/**
	 * 课程添加页面
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(Model model){
		//专业信息
		List<SubjectModel> subjects = courseService.querySubjectModels();
		model.addAttribute("subjects", subjects);
		return "admin/course/saveOrUpdate";
	}
	
	@RequestMapping("edit.do")
	public String edit(int id,Model model){
		//专业信息
		List<SubjectModel> subjects = courseService.querySubjectModels();
		model.addAttribute("subjects", subjects);
		
		CourseModel courseModel = courseService.queryCourseById(id);
		model.addAttribute("course",courseModel);
		return "admin/course/saveOrUpdate";
	}
	
	//修改和添加合并在一起
	@RequestMapping(value="saveOrUpdate.do",method=RequestMethod.POST)
	public String saveOrUpdate(CourseModel model){
		
		System.out.println("saveOrUpdate得到的信息："+model);
		
		//判断当前请求是添加信息或更新信息
		if(model.getId()>0){
			//更新请求
			model.setUpdateTime(new Date());
			//调用更新方法
			boolean b = courseService.updateCourseModel(model);
			System.out.println("更新课程信息是否成功："+b);
		}else{
			//新增请求
			model.setInsertTime(new Date());
			model.setUpdateTime(new Date());
			//调用新增方法
			int id = courseService.addCourseModel(model);
			System.out.println("新增课程信息，id为"+id);
		}
		
		return "redirect:/admin/course/index.do";
	}
		
	//删除方法
	@ResponseBody
	@RequestMapping("delete.do")
	public Map delete(int id){
		//根据id删除
		boolean b = courseService.deleteById(id);
		//封装结果
		HashMap map = new HashMap();
		if (b) {
			//删除成功
			map.put("success", true);
		} else {
			map.put("success", false);
			map.put("message", "删除视频信息失败，请重试");
		}

		return map;
		//return "redirect:/admin/course/index.do";
	}
	
	
	
}
