package com.zhiyou.video.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.service.ICourseService;

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
	public String index(Model model){
		
		
		List<CourseModel> results = courseService.queryCourseModels();
		model.addAttribute("results", results);
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
	@RequestMapping("delete.do")
	public String delete(int id){
		//根据id删除
		boolean b = courseService.deleteById(id);
		
		return "redirect:/admin/course/index.do";
	}
	
	
	
}
