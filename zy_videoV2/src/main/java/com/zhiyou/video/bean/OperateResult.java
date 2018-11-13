package com.zhiyou.video.bean;

/**
 * Descr: 封装操作结果
 *
 */
public class OperateResult {
	
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OperateResult [success=" + success + ", message=" + message + "]";
	}

	
}
