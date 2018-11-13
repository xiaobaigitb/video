package com.zhiyou.video.controller;

import java.util.List;

import com.zhiyou.video.annotation.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.service.ICourseService;
import com.zhiyou.video.service.IVideoService;
import com.zhiyou.video.util.TimeConverter;

/**
 * Descr:
 *
 */
@Controller
@RequestMapping("/front/course")
public class FrontCourseController extends FrontBaseController {
	
	@Autowired
	ICourseService courseService;
	@Autowired
	IVideoService videoService;
	
	/**
	 * 返回课程列表页面,此页面没有用ajax
	 * subjectId 学科id
	 * @return
	 */
	@RequestMapping("index.do")
	public String index(int subjectId,Model model){
		if(subjectId<1){
			model.addAttribute("message","学科信息有误");
			return "front/message";
		}
		
		SubjectModel subjectModel = courseService.querySubjectById(subjectId);
		model.addAttribute("subject",subjectModel);
		model.addAttribute("subjectId", subjectId);
		
		//根据学科id查询学科下所有的课程信息
		List<CourseModel> courses = courseService.queryCoursesBySubject(subjectId);
		if(courses!=null){
			//循环课程信息，根据课程信息查询视频信息
			for(CourseModel course : courses){
				//根据课程id查询所有的视频信息
				List<VideoModel> videos = videoService.queryVideosByCourse(course.getId());
				if(videos!=null&&videos.size()>0){
					for(VideoModel video:videos){
						video.setVideoLengthStr(TimeConverter.converter(video.getVideoLength()));
					}
				}
				//封装在课程的model类里
				course.setVideoList(videos);
			}
			
			model.addAttribute("courses",courses);
		}
		
		System.out.println(courses);
		
		return "front/course/index";
	}

}
