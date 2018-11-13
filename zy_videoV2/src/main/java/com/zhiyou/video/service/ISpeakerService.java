package com.zhiyou.video.service;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.SpeakerModel;
import com.zhiyou.video.util.PageInfo;

/**
 * Descr: 主讲人管理模块service接口
 *
 */
public interface ISpeakerService {

	//查询主讲人信息列表
	public List<SpeakerModel> querySpeakers();
	
	//添加主讲人信息
	public int addSpeakerModel(SpeakerModel model);
	
	//根据id查询主讲人信息
	public SpeakerModel querySpeakerById(int id);
	
	//根据id更新主讲人信息
	public boolean updateSpeakerById(SpeakerModel model);
	
	//根据查询条件查询主讲人信息列表
	public List<SpeakerModel> querySpeakerList(HashMap map);
	//添加分页的查询
	public PageInfo<SpeakerModel> querySpeakerPageList(HashMap map);
	
	public boolean deleteById(int id);
}
