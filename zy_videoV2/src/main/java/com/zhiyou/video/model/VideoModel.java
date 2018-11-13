package com.zhiyou.video.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.zhiyou.video.validator.VideoAddValidator;
import com.zhiyou.video.validator.VideoEditValidator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Descr:
 *
 */
public class VideoModel {
	
	@Min(value=1,message="视频id有错误",groups={VideoEditValidator.class})
	private int id;
	@NotEmpty(message="视频标题不能为空",groups={VideoEditValidator.class,VideoAddValidator.class})
	@Length(min=2,max=255,message="视频标题只能输入2-255个字符",groups={VideoEditValidator.class,VideoAddValidator.class})
	private String videoTitle;

	@NotNull(groups={VideoEditValidator.class,VideoAddValidator.class})
	@Min(value=1,groups={VideoEditValidator.class,VideoAddValidator.class})
	private Integer videoLength;
	@Length(max=255,groups={VideoEditValidator.class,VideoAddValidator.class})
	private String videoImageUrl;
	@Length(max=255)
	private String videoUrl;
	@Length(max=255)
	private String videoDescr;

	@Min(value=1)
	private int speakerId;

	@Min(value=1)
	private int courseId;
	
	private int videoPlayTimes;
	private Date insertTime;
	private Date updateTime;
	
	
	private String speakerName;
	private String courseName;
	//添加视频时长格式化字符串
	private String videoLengthStr;
	
	
	
	public String getVideoLengthStr() {
		return videoLengthStr;
	}
	public void setVideoLengthStr(String videoLengthStr) {
		this.videoLengthStr = videoLengthStr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	
	public Integer getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(Integer videoLength) {
		this.videoLength = videoLength;
	}
	public String getVideoImageUrl() {
		return videoImageUrl;
	}
	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoDescr() {
		return videoDescr;
	}
	public void setVideoDescr(String videoDescr) {
		this.videoDescr = videoDescr;
	}
	public int getVideoPlayTimes() {
		return videoPlayTimes;
	}
	public void setVideoPlayTimes(int videoPlayTimes) {
		this.videoPlayTimes = videoPlayTimes;
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
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "VideoModel [id=" + id + ", videoTitle=" + videoTitle + ", videoLength=" + videoLength
				+ ", videoImageUrl=" + videoImageUrl + ", videoUrl=" + videoUrl + ", videoDescr=" + videoDescr
				+ ", videoPlayTimes=" + videoPlayTimes + ", insertTime=" + insertTime + ", updateTime=" + updateTime
				+ ", speakerId=" + speakerId + ", courseId=" + courseId + ", speakerName=" + speakerName
				+ ", courseName=" + courseName + "]";
	}
	
}
