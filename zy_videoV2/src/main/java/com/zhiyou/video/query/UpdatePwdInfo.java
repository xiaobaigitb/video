package com.zhiyou.video.query;

/**
 * Descr: 更新密码时提交的信息
 *
 */
public class UpdatePwdInfo {
	
	private String oldPassword;
	private String newPassword;
	private String newPasswordAgain;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordAgain() {
		return newPasswordAgain;
	}
	public void setNewPasswordAgain(String newPasswordAgain) {
		this.newPasswordAgain = newPasswordAgain;
	}
	@Override
	public String toString() {
		return "UpdatePwdInfo [oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", newPasswordAgain="
				+ newPasswordAgain + "]";
	}

}
