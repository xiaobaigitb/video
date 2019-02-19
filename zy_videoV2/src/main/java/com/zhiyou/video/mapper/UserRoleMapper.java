package com.zhiyou.video.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.lu
 * @Title: UserRoleMapper
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:28
 */
public interface UserRoleMapper {
    void addUserRoleModel(@Param("userId") int userId, int i);

    void addUserRoleModelByUserId(@Param("userId") int userId,@Param("roleId") int roleId);

    void updateUserRoleModelByUserId(@Param("userId") int userId,@Param("roleId") int roleId);
}
