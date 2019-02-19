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
    private String intent;
    private String age;
    private String sex;
    private String classTime;
    private String alreadyTime;

    public String getAlreadyTime() {
        return alreadyTime;
    }

    public void setAlreadyTime(String alreadyTime) {
        this.alreadyTime = alreadyTime;
    }

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

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Override
    public String toString() {
        return "CallerModel{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", tel='" + tel + '\'' +
                ", intent='" + intent + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", classTime='" + classTime + '\'' +
                ", alreadyTime='" + alreadyTime + '\'' +
                '}';
    }
}
