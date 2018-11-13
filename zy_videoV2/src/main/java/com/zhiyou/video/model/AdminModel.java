package com.zhiyou.video.model;

/**
 * Descr: 管理员登录信息model类
 *
 */
public class AdminModel {
	
	private int id;
	private String loginName;
	private String loginPwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	
}
