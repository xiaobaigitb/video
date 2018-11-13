package com.zhiyou.video.query;

/**
 * Descr: 封装注册用户信息的类
 *
 */
public class RegistUserInfo {

	private String email;
	private String password;
	private String pswAgain;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPswAgain() {
		return pswAgain;
	}
	public void setPswAgain(String pswAgain) {
		this.pswAgain = pswAgain;
	}
	@Override
	public String toString() {
		return "RegistUserInfo [email=" + email + ", password=" + password + ", pswAgain=" + pswAgain + "]";
	}
	
}
