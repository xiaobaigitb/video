package com.zhiyou.video.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.video.model.AdminModel;
import com.zhiyou.video.service.IAdminService;

/**
 * 
 * @author Administrator
 *
 *	后台用户登录、退出等功能
 */
@Controller
@RequestMapping("/admin")
public class HomeController {
	
	@Autowired
	IAdminService adminService;

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public String loginGet(HttpSession session){
		System.out.println("login method");
		
		//如果已经登录了，直接跳转功能
		if(session.getAttribute("session_user")!=null){
			return "redirect:/admin/speaker/index.do";
		}
		
		return "admin/login";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("session_user");
		
		return "redirect:/admin/login.do";
	}
	
	/**
	 * 获取提交的登录信息，校验登录是否成功
	 * @param loginName
	 * @param loginPwd
	 * @return 登录成功则跳转到功能页面，登录失败则返回登录页面
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String loginPost(String loginName,String loginPwd,Model model,HttpSession session){
		
		AdminModel adminModel = adminService.login(loginName, loginPwd);
		
		if(adminModel==null){
			System.out.println("登录失败："+loginName+"--"+loginPwd);
			//返回个错误信息，跳回到登录页面
			model.addAttribute("message", "用户名或密码错误，登录失败");
			return "admin/login";
		}else{
			System.out.println("登录成功："+loginName+"--"+loginPwd);
			//登录成功需要将用户的信息放到session中，以便校验用户是否登录
			session.setAttribute("session_user", adminModel);
			//重定向到指定的功能页面
			return "redirect:/admin/speaker/index.do";
		}

	}
}
