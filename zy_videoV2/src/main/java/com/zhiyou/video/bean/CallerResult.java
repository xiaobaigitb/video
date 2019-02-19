package com.zhiyou.video.bean;

import com.zhiyou.video.model.CallerModel;

/**
 * Descr: 预约用户的操作结果
 *
 */
public class CallerResult extends OperateResult {

	private CallerModel caller;

	public CallerModel getCaller() {
		return caller;
	}

	public void setCaller(CallerModel caller) {
		this.caller = caller;
	}

	@Override
	public String toString() {
		return "CallerResult{" +
				"caller=" + caller +
				'}';
	}
}
