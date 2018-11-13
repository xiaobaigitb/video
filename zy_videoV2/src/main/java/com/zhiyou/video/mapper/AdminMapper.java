package com.zhiyou.video.mapper;

import java.util.HashMap;

import com.zhiyou.video.model.AdminModel;

/**
 * Descr:
 *
 */
public interface AdminMapper {

	//根据用户名密码查询管理员，查询信息封装为hashmap
	public AdminModel loginByName(HashMap map);
	
}
