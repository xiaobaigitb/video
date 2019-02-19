package com.zhiyou.video.service;

/**
 * @author Mr.lu
 * @Title: UserRoleService
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:24
 */
public interface UserRoleService {

    void addUserRoleModel(int userId, int i);

    void addUserRoleModelByUserId(int userId, int roleId);

    void updateUserRoleModelByUserId(int userId, int roleId);
}
