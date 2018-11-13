package com.zhiyou.video.mapper;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.UserModel;

/**
 * Descr:
 *
 */
public interface FrontUserMapper {
	
	public UserModel queryUserByEmail(String email);
	
	public int insertUserModel(UserModel model);
	
	public UserModel queryUserById(int id);
	
	public void updateCaptcha(HashMap map);
	
	public int updateUserPwd(HashMap map);
	
	public int updateUserInfo(UserModel user);
	
	public int updateUserHead(HashMap map);

    List<String> selectRolesById(int id);
}
