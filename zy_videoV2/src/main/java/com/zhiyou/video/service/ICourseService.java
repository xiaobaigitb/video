package com.zhiyou.video.service;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.util.PageInfo;

/**
 * Descr:
 *
 */
public interface ICourseService {
	
	public List<SubjectModel> querySubjectModels();

	public List<CourseModel> queryCourseModels();
	
	public CourseModel queryCourseById(int id);
	
	public int addCourseModel(CourseModel model);
	
	public boolean updateCourseModel(CourseModel model);
	
	public boolean deleteById(int id);
	
	public List<CourseModel> queryCoursesBySubject(int subject);
	
	public SubjectModel querySubjectById(int subject);

    PageInfo<CourseModel> queryCoursePageList(HashMap map);
}
