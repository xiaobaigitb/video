package com.zhiyou.video.mapper;

import java.util.List;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;

/**
 * Descr:
 *
 */
public interface CourseMapper {
	public List<SubjectModel> querySubjectModels();

	public List<CourseModel> queryCourseModels();
	
	public CourseModel queryCourseById(int id);
	
	public int addCourseModel(CourseModel model);
	
	public int updateCourseModel(CourseModel model);
	
	public int deleteById(int id);
	
	public List<CourseModel> queryCoursesBySubject(int id);
	
	public SubjectModel querySubjectById(int id);
	
}
