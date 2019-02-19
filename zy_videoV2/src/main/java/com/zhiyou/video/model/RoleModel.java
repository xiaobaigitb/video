package com.zhiyou.video.model;

/**
 * @author Mr.lu
 * @Title: UserRoleModel
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/14:19:22
 */
public class RoleModel {
    private int id;
    private String roleName;


    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
