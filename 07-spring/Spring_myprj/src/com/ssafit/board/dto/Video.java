package com.ssafit.board.dto;

public class Video {
	private String id;
	private String title;
	private String part;
	private String viewCnt;
	private String duration;
	private String reviewCnt;
	private String channel_name;
	public Video(String id, String title, String part, String viewCnt, String duration, String reviewCnt,
			String channel_name) {
		super();
		this.id = id;
		this.title = title;
		this.part = part;
		this.viewCnt = viewCnt;
		this.duration = duration;
		this.reviewCnt = reviewCnt;
		this.channel_name = channel_name;
	}
	public Video() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getReviewCnt() {
		return reviewCnt;
	}
	public void setReviewCnt(String reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	
	
	
}
