package com.zhiyou.video.query;

/**
 * Descr: 重置密码的信息
 *
 */
public class ResetPwdInfo {
	private String email;
	private String captcha;
	private String password;
	private String pwdAgain;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwdAgain() {
		return pwdAgain;
	}
	public void setPwdAgain(String pwdAgain) {
		this.pwdAgain = pwdAgain;
	}
	@Override
	public String toString() {
		return "ResetPwdInfo [email=" + email + ", captcha=" + captcha + ", password=" + password + ", pwdAgain="
				+ pwdAgain + "]";
	}
	
	
}
