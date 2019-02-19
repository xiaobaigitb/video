package com.zhiyou.video.service.impl;

import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.model.CourseModel;
import com.zhiyou.video.model.SubjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.AdminMapper;
import com.zhiyou.video.model.AdminModel;
import com.zhiyou.video.service.IAdminService;
import com.zhiyou.video.util.MD5Utils;

/**
 * Descr: 管理员操作相关
 *
 */
@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	AdminMapper mapper;

	@Override
	public AdminModel login(String loginName, String loginPwd) {
		//必须将页面提交的密码经过加密才能和数据库的做对比
		String pwd = MD5Utils.getMd5Simple(loginPwd);
		HashMap map = new HashMap();
		map.put("loginName",loginName);
		map.put("loginPwd", pwd);
		AdminModel model = mapper.loginByName(map);
		
		return model;
	}

	@Override
	public List<AdminModel> queryAdminModels() {

		return mapper.queryAdminModels();
	}

	@Override
	public boolean deleteById(int id) {
		return mapper.deleteById(id);
	}

	@Override
	public AdminModel queryAdminById(int id) {
		return mapper.queryAdminById(id);
	}

	@Override
	public int addAdminModel(AdminModel model) {
		return mapper.addAdminModel(model);
	}

	@Override
	public boolean updateAdminModel(AdminModel model) {
		return mapper.updateAdminModel(model);
	}

}
