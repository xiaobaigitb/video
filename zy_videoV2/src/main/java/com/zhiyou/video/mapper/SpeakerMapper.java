package com.zhiyou.video.mapper;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.SpeakerModel;

/**
 * Descr: 主讲人mapper
 *
 */
public interface SpeakerMapper {
	
	//查询主讲人信息列表
	public List<SpeakerModel> querySpeakers();
	//添加主讲人信息
	public int insertSpeakerModel(SpeakerModel model);
	
	public SpeakerModel querySpeakerById(int id);
	
	public int updateSpeakerById(SpeakerModel model);
	
	public List<SpeakerModel> querySpeakerList(HashMap map);

	public int deleteById(int id);
	
	public int querySpeakerListCount(HashMap map);
}
