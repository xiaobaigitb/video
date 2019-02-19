package com.zhiyou.video.service;

import com.zhiyou.video.bean.RegistResult;
import com.zhiyou.video.bean.LoginResult;
import com.zhiyou.video.bean.OperateResult;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.query.RegistUserInfo;
import com.zhiyou.video.query.UpdatePwdInfo;
import com.zhiyou.video.util.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Descr:
 *
 */
public interface IFrontUserService {
	
	//注册新用户
	public RegistResult registUser(RegistUserInfo userInfo);
	
	//用户登录
	public LoginResult loginUser(String email,String pwd);
	
	public UserModel queryUserByEmail(String email);
	
	public UserModel queryUserById(int id);
	
	//更新用户密码
	public boolean updateUserPwd(int id,String pwd);
	
	public boolean updateUserInfo(UserModel model);
	
	public boolean updateUserHead(int id,String head);
	
	//清空用户的验证码信息
	public void cleanCaptcha(String email);
	
	//保存验证码
	public void updateUserCaptcha(String email,String captcha);
	
	public OperateResult updateUserPassword(int id,UpdatePwdInfo info);

	//通过ID查找用户的权限
    List<String> selectRolesById(int id);

	List<UserModel> selectUserList();

	void updateUserStatus(int userId);

    List<UserModel> queryUserModels();

    boolean deleteById(int id);

    boolean updateUserById(UserModel model);

	int addUserModel(UserModel model);

    PageInfo<UserModel> queryUserPageList(HashMap map);

	void updateUserRoleId(int i);

	void updateUserSubjectById(int userId);

	void updateUserStatusByEmail(String email);
}
