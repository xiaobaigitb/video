package com.zhiyou.video.service;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.query.VideoListQuery;

/**
 * Descr:
 *
 */
public interface IVideoService {
	
	public List<VideoModel> queryVideoModels(VideoListQuery query);
	
	public int addVideoModel(VideoModel model);
	
	public boolean updateVideoModel(VideoModel model);
	
	public boolean deleteById(int id);
	
	public VideoModel queryVideoById(int id);

	public List<VideoModel> queryVideosByCourse(int course);
	
	
	public void updateVideoPlaytimes(int id);
	
	//统计每个课程下视频的平均播放次数
	public List<HashMap> stateCourseAvgPlaytimes();
	
	
}
