package com.zhiyou.video.model;


/**
 * @author Mr.lu
 * @Title: CallerModel
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:18:48
 * 访客报名的信息对象实体
 */
public class CallerModel {
    private int id;
    private String visitorName;
    private String tel;
    private String qq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "CallerModel{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
