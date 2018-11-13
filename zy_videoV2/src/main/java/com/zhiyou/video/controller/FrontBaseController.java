package com.zhiyou.video.controller;

import javax.servlet.http.HttpSession;

import com.zhiyou.video.model.UserModel;

/**
 * Descr: 放置一些前台控制器公用的功能
 *
 */
public class FrontBaseController {

	static final String SESSION_USER = "_front_user";
	
	static final int CAPTCHA_LENGTH = 5;//验证码长度
	
	/**
	 * 用户登陆后，将用户信息放到session中，但是哪些信息要放，可以在这里统一管理
	 * 
	 * @param session
	 * @param user
	 */
	public void loginSession(HttpSession session,UserModel user){
		session.setAttribute(SESSION_USER, user);
	}
	
	/**
	 * 获取当前已登录用户信息
	 *
	 * @param session
	 * @return
	 */
	public UserModel getCurrentUser(HttpSession session){
		return (UserModel)session.getAttribute(SESSION_USER);
	}
	
	/**
	 * 用户退出登录时，需要从session中移除哪些信息，也可以统一在这里管理
	 * 
	 * @param session
	 */
	public void logoutSession(HttpSession session){
		session.removeAttribute(SESSION_USER);
	}
	
}
