package com.zhiyou.video.bean;

import com.zhiyou.video.model.UserModel;

/**
 * Descr: 用户登录的操作结果
 *
 */
public class LoginResult extends OperateResult {

	private UserModel user;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginResult [user=" + user + ", toString()=" + super.toString() + "]";
	}
	
	
}
