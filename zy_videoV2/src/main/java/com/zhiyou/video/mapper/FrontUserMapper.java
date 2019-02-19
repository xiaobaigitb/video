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

    List<UserModel> selectUserList();

	void updateUserStatus(int userId);

    List<UserModel> queryUserModels();

    boolean deleteById(int id);

	boolean addUserModel(UserModel model);

	boolean updateUserById(UserModel model);

	List<UserModel> queryUserPageList(HashMap map);

	int queryUserListCount(HashMap map);

	void updateUserRoleId(int userId);

	void updateUserSubjectById(int userId);

	void updateUserStatusByEmail(String email);
}
