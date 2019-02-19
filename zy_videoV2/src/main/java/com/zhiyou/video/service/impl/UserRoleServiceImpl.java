package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.UserRoleMapper;
import com.zhiyou.video.service.UserRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.lu
 * @Title: UserRoleServiceImpl
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:27
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper mapper;
    @Override
    public void addUserRoleModel(@Param("userId") int userId, int i) {
        mapper.addUserRoleModel(userId,2);
    }

    @Override
    public void addUserRoleModelByUserId(@Param("userId") int userId,@Param("roleId") int roleId) {
        mapper.addUserRoleModelByUserId(userId,roleId);
    }

    @Override
    public void updateUserRoleModelByUserId(@Param("userId") int userId,@Param("roleId")  int roleId) {
        mapper.updateUserRoleModelByUserId(userId,roleId);
    }
}
