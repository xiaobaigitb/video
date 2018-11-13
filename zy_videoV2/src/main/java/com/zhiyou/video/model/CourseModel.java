package com.zhiyou.video.model;

import java.util.Date;
import java.util.List;

/**
 * Descr:
 *
 */
public class CourseModel {
	
	private int id;
	private String courseName;
	private String courseDescr;
	private Date insertTime;
	private Date updateTime;
	private int subjectId;
	private String subjectName;
	
	
	//视频集合
	private List<VideoModel> videoList;
	
	public List<VideoModel> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<VideoModel> videoList) {
		this.videoList = videoList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescr() {
		return courseDescr;
	}
	public void setCourseDescr(String courseDescr) {
		this.courseDescr = courseDescr;
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
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", courseName=" + courseName + ", courseDescr=" + courseDescr + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", subjectId=" + subjectId + ", subjectName="
				+ subjectName + ", videoList=" + videoList + "]";
	}
	
}
