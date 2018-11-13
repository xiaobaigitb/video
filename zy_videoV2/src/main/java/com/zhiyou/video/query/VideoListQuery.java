package com.zhiyou.video.query;

/**
 * Descr:
 *
 */
public class VideoListQuery {
	
	private String queryName;
	private int speakerId;
	private int courseId;
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "VideoListQuery [queryName=" + queryName + ", speakerId=" + speakerId + ", courseId=" + courseId + "]";
	}
	

}
