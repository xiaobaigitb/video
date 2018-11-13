package com.zhiyou.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Descr:
 *
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@RequestMapping("test.do")
	public String test(){
		System.out.println("ajax test");
		return "ajax";
	}
	
	@ResponseBody
	@RequestMapping("data.do")
	public String ajax(){
		System.out.println("ajax data");
		return "ajax_data"+System.currentTimeMillis();
	}
	
	@RequestMapping("load.do")
	public String load(){
		System.out.println("ajax data");
		return "ajax_data";
	}


}
