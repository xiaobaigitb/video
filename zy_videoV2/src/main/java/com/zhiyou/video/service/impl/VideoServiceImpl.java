package com.zhiyou.video.service.impl;

import java.util.HashMap;
import java.util.List;

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

}
