package com.zhiyou.video.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.video.service.IVideoService;

/**
 * Descr: 做统计图表所用的
 *
 */
@Controller
@RequestMapping("/admin/state")
public class StateController {
	
	@Autowired
	IVideoService videoService;

	/**
	 * 统计每个课程下的视频平均播放次数
	 * 
	 * @return
	 */
	@RequestMapping("courseavg.do")
	public String courseAvg(Model model){
		List<HashMap> list = videoService.stateCourseAvgPlaytimes();
		
		System.out.println(">>>统计结果："+list);
		
		//分析结果数据，组装为页面所需要的x轴和y轴数据
		StringBuffer xbuffer = new StringBuffer();
		StringBuffer ybuffer = new StringBuffer();
		
		List<String> xlist = new ArrayList<String>();
		List<Integer> ylist = new ArrayList<Integer>();
		if(list!=null){
			for(HashMap map : list){
				xlist.add(map.get("course_name").toString());
				ylist.add(Integer.parseInt(map.get("avgTimes").toString()));
			}
		}
	
		//x轴数据拼接
		xbuffer.append("[");
		for(int i=0;i<xlist.size();i++){
			if(i==0){
				xbuffer.append("'"+xlist.get(i)+"'");
			}else{
				xbuffer.append(",'"+xlist.get(i)+"'");
			}
		}
		xbuffer.append("]");
		
		
		//y轴的数据拼接
		ybuffer.append("[{name:'平均播放次数',");
		ybuffer.append(" data: [");
		for(int j=0;j<ylist.size();j++){
			if(j==0){
				ybuffer.append(ylist.get(j));
			}else{
				ybuffer.append(","+ylist.get(j));
			}
		}
		ybuffer.append("]}]");
		
		
		model.addAttribute("xdata",xbuffer.toString());
		model.addAttribute("ydata",ybuffer.toString());
		
		return "admin/state/index";
	}
	
	/**
	 * 通过ajax返回数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxdata.do")
	public Object ajaxData(){
		List<HashMap> list = videoService.stateCourseAvgPlaytimes();
		List<String> xlist = new ArrayList<String>();
		List<Integer> ylist = new ArrayList<Integer>();
		if(list!=null){
			for(HashMap map : list){
				xlist.add(map.get("course_name").toString());
				ylist.add(Integer.parseInt(map.get("avgTimes").toString()));
			}
		}
		
		//封装所有结果的map
		HashMap resultMap = new HashMap();
		
		HashMap ymap = new HashMap();
		ymap.put("name", "平均播放次数");
		ymap.put("data", ylist);
		List yy = new ArrayList();
		yy.add(ymap);
		
		resultMap.put("xdata",xlist);
		resultMap.put("ydata",yy);
		
		return resultMap;
	}
	
	
}
