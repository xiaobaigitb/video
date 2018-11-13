package com.zhiyou.video.service;

import com.zhiyou.video.model.AdminModel;

/**
 * Descr:
 *
 */
public interface IAdminService {

	/**
	 * 登录方法，根据用户名密码查询admin信息，如果返回不为空则登录成功
	 * 返回为空则说明登录失败
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public AdminModel login(String loginName,String loginPwd);
	
}
