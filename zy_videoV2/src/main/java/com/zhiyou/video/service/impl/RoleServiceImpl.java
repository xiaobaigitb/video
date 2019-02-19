package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.RoleMapper;
import com.zhiyou.video.mapper.UserRoleMapper;
import com.zhiyou.video.model.RoleModel;
import com.zhiyou.video.service.RoleService;
import com.zhiyou.video.service.UserRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.lu
 * @Title: UserRoleServiceImpl
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleModel> queryRoles() {
        return roleMapper.queryRoles();
    }
}
