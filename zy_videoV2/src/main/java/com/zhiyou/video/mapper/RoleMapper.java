package com.zhiyou.video.mapper;

import com.zhiyou.video.model.RoleModel;
import com.zhiyou.video.model.SubjectModel;

import java.util.List;

/**
 * Descr: 主讲人mapper
 *
 */
public interface RoleMapper {
	List<RoleModel> queryRoles();
}
