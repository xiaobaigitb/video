package com.zhiyou.video.service.impl;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.VideoMapper;
import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.query.VideoListQuery;
import com.zhiyou.video.service.IVideoService;

/**
 * Descr:
 *
 */
@Service
public class VideoServiceImpl implements IVideoService {
	@Autowired
	VideoMapper mapper;
	
	@Override
	public List<VideoModel> queryVideoModels(VideoListQuery query) {
		return mapper.queryVideoModels(query);
	}

	@Override
	public int addVideoModel(VideoModel model) {
		return mapper.addVideoModel(model);
	}

	@Override
	public boolean updateVideoModel(VideoModel model) {
		int i = mapper.updateVideoModel(model);
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
	public VideoModel queryVideoById(int id) {
		// TODO Auto-generated method stub
		return mapper.queryVideoById(id);
	}

	@Override
	public List<VideoModel> queryVideosByCourse(int course) {
		// TODO Auto-generated method stub
		return mapper.queryVideosByCourse(course);
	}

	@Override
	public void updateVideoPlaytimes(int id) {
		mapper.updateVideoPlaytimes(id);
	}

	@Override
	public List<HashMap> stateCourseAvgPlaytimes() {
		return mapper.stateCourseAvgPlaytimes();
	}

	@Override
	public PageInfo<VideoModel> queryVideoPageList(HashMap map) {
		int pageNum = Integer.parseInt(map.get("pageNum").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int allNum = 0;//总数量
		int pageNums = 0;//总页数

		allNum = mapper.queryVideoListCount(map);
		if(allNum%pageSize==0){
			pageNums = allNum/pageSize;
		}else{
			pageNums = allNum/pageSize+1;
		}

		int start = (pageNum-1)*pageSize;//查询sql数据的起始位置

		//查询数据
		map.put("start", start);
		List<VideoModel> result = mapper.queryVideoPageList(map);

		//封装
		PageInfo<VideoModel> pageinfo = new PageInfo<VideoModel>();
		pageinfo.setAllNum(allNum);
		pageinfo.setPageNum(pageNum);
		pageinfo.setPageNums(pageNums);
		pageinfo.setPageSize(pageSize);
		pageinfo.setResults(result);

		return pageinfo;
	}

}
