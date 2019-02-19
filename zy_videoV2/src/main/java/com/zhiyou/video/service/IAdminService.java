package com.zhiyou.video.service;

import com.zhiyou.video.model.AdminModel;
import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;

import java.util.List;

/**
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


	//查询管理员用户信息
	public List<AdminModel> queryAdminModels();
	//通过ID删除管理员
	public boolean deleteById(int id);
	//通过ID查询出管理员用户
	public AdminModel queryAdminById(int id);
	//添加管理员
	public int addAdminModel(AdminModel model);
	//更新管理员信息
	public boolean updateAdminModel(AdminModel model);
	
}
