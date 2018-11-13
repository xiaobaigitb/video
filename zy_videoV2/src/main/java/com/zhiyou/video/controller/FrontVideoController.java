package com.zhiyou.video.controller;

import java.util.List;

import com.zhiyou.video.annotation.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SpeakerModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.service.ICourseService;
import com.zhiyou.video.service.ISpeakerService;
import com.zhiyou.video.service.IVideoService;
import com.zhiyou.video.util.TimeConverter;

/**
 * Descr: 前台视频播放页
 *
 */
@Controller
@RequestMapping("/front/video")
public class FrontVideoController extends FrontBaseController {

	@Autowired
	IVideoService videoService;
	
	@Autowired
	ICourseService courseService;
	
	@Autowired
	ISpeakerService speakerService;
	
	
	/**
	 * 只返回视频播放页面，页面内容使用ajax加载
	 * 
	 * @return
	 */
	@RequestMapping("index.do")
	public String index(int videoId,int subjectId,Model model){
		SubjectModel subjectModel = courseService.querySubjectById(subjectId);
		model.addAttribute("subject",subjectModel);
		model.addAttribute("subjectId", subjectId);
		
		model.addAttribute("videoId",videoId);
		
		return "front/video/index";
	}
	
	@RequestMapping("videoData.do")
	@Permission(role = {"super"})//自定义注解用于设置访问权限
	public String data(int videoId,Model model){
		//查询当前视频的信息
		VideoModel video = videoService.queryVideoById(videoId);
		video.setVideoLengthStr(TimeConverter.converter(video.getVideoLength()));
		model.addAttribute("video",video);
		
		//查询此视频主讲人信息
		SpeakerModel speakerModel = speakerService.querySpeakerById(video.getSpeakerId());
		model.addAttribute("speaker",speakerModel);
		
		//查询此视频所属课程的信息
		CourseModel courseModel = courseService.queryCourseById(video.getCourseId());
		model.addAttribute("course",courseModel);
		
		
		//查询此视频同课程下的其它视频信息
		List<VideoModel> videos = videoService.queryVideosByCourse(video.getCourseId());
		if(videos!=null&&videos.size()>0){
			for(VideoModel vi:videos){
				vi.setVideoLengthStr(TimeConverter.converter(vi.getVideoLength()));
			}
		}
		model.addAttribute("videoList",videos);
		
		//学科的信息
		model.addAttribute("subjectId",courseModel.getSubjectId());
		
		
		//播放量统计，videoPlayTimes+1，更新
		
		
		return "front/video/content";
	}
	
	/**
	 * 视频播放量统计
	 * 
	 * @param videoId
	 */
	@RequestMapping("state.do")
	public void state(int videoId){
		//更新播放量字段，ajax调用，不需要返回结果
		videoService.updateVideoPlaytimes(videoId);
	}
	
}
