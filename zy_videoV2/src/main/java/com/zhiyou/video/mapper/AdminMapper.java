package com.zhiyou.video.mapper;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.AdminModel;
import com.zhiyou.video.model.CourseModel;

/**
 * Descr:
 *
 */
public interface AdminMapper {

	//根据用户名密码查询管理员，查询信息封装为hashmap
	public AdminModel loginByName(HashMap map);

	public List<AdminModel> queryAdminModels();

	boolean deleteById(int id);

	AdminModel queryAdminById(int id);

	int addAdminModel(AdminModel model);

	boolean updateAdminModel(AdminModel model);
}
