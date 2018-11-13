package com.zhiyou.video.model;

import java.util.Date;

/**
 * Descr: 主讲人model类
 *
 */
public class SpeakerModel {

	private int id;
	private String speakerName;
	private String speakerJob;
	private String speakerHeadUrl;
	private String speakerDescr;
	private Date insertTime;
	private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}
	public String getSpeakerHeadUrl() {
		return speakerHeadUrl;
	}
	public void setSpeakerHeadUrl(String speakerHeadUrl) {
		this.speakerHeadUrl = speakerHeadUrl;
	}
	public String getSpeakerDescr() {
		return speakerDescr;
	}
	public void setSpeakerDescr(String speakerDescr) {
		this.speakerDescr = speakerDescr;
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
	@Override
	public String toString() {
		return "SpeakerModel [id=" + id + ", speakerName=" + speakerName + ", speakerJob=" + speakerJob
				+ ", speakerHeadUrl=" + speakerHeadUrl + ", speakerDescr=" + speakerDescr + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + "]";
	}

}
