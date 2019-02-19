package com.zhiyou.video.mapper;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.VideoModel;
import com.zhiyou.video.query.VideoListQuery;

/**
 * Descr:
 *
 */
public interface VideoMapper {
	public List<VideoModel> queryVideoModels(VideoListQuery query);
	
	public VideoModel queryVideoById(int id);
	
	public int addVideoModel(VideoModel model);
	
	public int updateVideoModel(VideoModel model);
	
	public int deleteById(int id);
	
	public List<VideoModel> queryVideosByCourse(int id);
	
	public void updateVideoPlaytimes(int id);
	
	public List<HashMap> stateCourseAvgPlaytimes();

    int queryVideoListCount(HashMap map);

	List<VideoModel> queryVideoPageList(HashMap map);
}
