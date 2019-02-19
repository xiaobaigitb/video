package com.zhiyou.video.service.impl;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.CourseMapper;
import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.service.ICourseService;

/**
 * Descr:
 *
 */
@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	CourseMapper mapper;
	
	@Override
	public List<SubjectModel> querySubjectModels() {
		return mapper.querySubjectModels();
	}

	@Override
	public List<CourseModel> queryCourseModels() {
		return mapper.queryCourseModels();
	}

	@Override
	public int addCourseModel(CourseModel model) {
		mapper.addCourseModel(model);
		return model.getId();
	}

	@Override
	public boolean updateCourseModel(CourseModel model) {
		int i = mapper.updateCourseModel(model);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		int i = mapper.deleteById(id);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public CourseModel queryCourseById(int id) {

		return mapper.queryCourseById(id);
	}

	@Override
	public List<CourseModel> queryCoursesBySubject(int subject) {
		// TODO Auto-generated method stub
		return mapper.queryCoursesBySubject(subject);
	}

	@Override
	public SubjectModel querySubjectById(int subject) {
		// TODO Auto-generated method stub
		return mapper.querySubjectById(subject);
	}

	@Override
	public PageInfo<CourseModel> queryCoursePageList(HashMap map) {
		int pageNum = Integer.parseInt(map.get("pageNum").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int allNum = 0;//总数量
		int pageNums = 0;//总页数

		allNum = mapper.queryCourseListCount(map);
		if(allNum%pageSize==0){
			pageNums = allNum/pageSize;
		}else{
			pageNums = allNum/pageSize+1;
		}

		int start = (pageNum-1)*pageSize;//查询sql数据的起始位置

		//查询数据
		map.put("start", start);
		List<CourseModel> result = mapper.queryCoursePageList(map);

		//封装
		PageInfo<CourseModel> pageinfo = new PageInfo<CourseModel>();
		pageinfo.setAllNum(allNum);
		pageinfo.setPageNum(pageNum);
		pageinfo.setPageNums(pageNums);
		pageinfo.setPageSize(pageSize);
		pageinfo.setResults(result);

		return pageinfo;
	}

}
