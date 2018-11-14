package com.zhiyou.video.model;

import java.util.Date;
import java.util.List;

/**
 * Descr: 前台用户model
 *
 */
public class UserModel {
	
	private int id;
	private String nickName;
	private int sex;
	private Date birthday;
	private String birthdayStr;//出生日期的格式化字符串
	private String email;
	private String province;
	private String city;
	private String headUrl;
	private String password;
	private Date insertTime;
	private Date updateTime;
	private String captcha;
	private int status;
	private List<String> roles;//存放权限名
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserModel{" +
				"id=" + id +
				", nickName='" + nickName + '\'' +
				", sex=" + sex +
				", birthday=" + birthday +
				", birthdayStr='" + birthdayStr + '\'' +
				", email='" + email + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", headUrl='" + headUrl + '\'' +
				", password='" + password + '\'' +
				", insertTime=" + insertTime +
				", updateTime=" + updateTime +
				", captcha='" + captcha + '\'' +
				", roles=" + roles +
				", status=" + status +
				'}';
	}
}
