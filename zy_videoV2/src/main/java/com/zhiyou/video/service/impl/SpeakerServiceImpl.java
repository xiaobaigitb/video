package com.zhiyou.video.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.SpeakerMapper;
import com.zhiyou.video.model.SpeakerModel;
import com.zhiyou.video.service.ISpeakerService;
import com.zhiyou.video.util.PageInfo;

/**
 * Descr: 主讲人管理
 *
 */
@Service
public class SpeakerServiceImpl implements ISpeakerService {

	@Autowired
	SpeakerMapper mapper;
	
	@Override
	public List<SpeakerModel> querySpeakers() {
		System.out.println(">>>>>> SpeakerServiceImpl querySpeakers");
		return mapper.querySpeakers();
	}
	
	@Override
	public int addSpeakerModel(SpeakerModel model){
		int i = mapper.insertSpeakerModel(model);
		return model.getId();
	}

	@Override
	public SpeakerModel querySpeakerById(int id) {
		
		return mapper.querySpeakerById(id);
	}

	@Override
	public boolean updateSpeakerById(SpeakerModel model) {
		int i = mapper.updateSpeakerById(model);
		//根据返回的数字判断当前更新操作是否成功
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public List<SpeakerModel> querySpeakerList(HashMap map) {
		
		return mapper.querySpeakerList(map);
	}

	@Override
	public boolean deleteById(int id) {
		int i = mapper.deleteById(id);
		if(i>0){
			return true;
		}
		return false;
	}

	/**
	 * 具体的分页过程
	 */
	@Override
	public PageInfo<SpeakerModel> querySpeakerPageList(HashMap map) {
		int pageNum = Integer.parseInt(map.get("pageNum").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int allNum = 0;//总数量
		int pageNums = 0;//总页数
		
		allNum = mapper.querySpeakerListCount(map);
		if(allNum%pageSize==0){
			pageNums = allNum/pageSize;
		}else{
			pageNums = allNum/pageSize+1;
		}
		
		int start = (pageNum-1)*pageSize;//查询sql数据的起始位置
		
		//查询数据
		map.put("start", start);
		List<SpeakerModel> result = mapper.querySpeakerList(map);
		
		//封装
		PageInfo<SpeakerModel> pageinfo = new PageInfo<SpeakerModel>();
		pageinfo.setAllNum(allNum);
		pageinfo.setPageNum(pageNum);
		pageinfo.setPageNums(pageNums);
		pageinfo.setPageSize(pageSize);
		pageinfo.setResults(result);
		
		return pageinfo;
	}

}
