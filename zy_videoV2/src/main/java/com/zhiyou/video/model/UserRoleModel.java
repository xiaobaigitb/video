package com.zhiyou.video.model;

/**
 * @author Mr.lu
 * @Title: UserRoleModel
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:22
 */
public class UserRoleModel {
    private int userId;
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleModel{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
