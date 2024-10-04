package com.ssafy.gt.user.model.dto;

public class Video {
	private String videoId;
	private String videoTitle;
	private String videoPart;
	private String channelName;
	private int videoViewcnt;
	private int videoLength;
	private int videoReviewcnt;
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(String videoId, String videoTitle, String videoPart, String channelName, int videoViewcnt,
			int videoLength, int videoReviewcnt) {
		super();
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.videoPart = videoPart;
		this.channelName = channelName;
		this.videoViewcnt = videoViewcnt;
		this.videoLength = videoLength;
		this.videoReviewcnt = videoReviewcnt;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoPart() {
		return videoPart;
	}
	public void setVideoPart(String videoPart) {
		this.videoPart = videoPart;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getVideoViewcnt() {
		return videoViewcnt;
	}
	public void setVideoViewcnt(int videoViewcnt) {
		this.videoViewcnt = videoViewcnt;
	}
	public int getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(int videoLength) {
		this.videoLength = videoLength;
	}
	public int getVideoReviewcnt() {
		return videoReviewcnt;
	}
	public void setVideoReviewcnt(int videoReviewcnt) {
		this.videoReviewcnt = videoReviewcnt;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoPart=" + videoPart
				+ ", channelName=" + channelName + ", videoViewcnt=" + videoViewcnt + ", videoLength=" + videoLength
				+ ", videoReviewcnt=" + videoReviewcnt + "]";
	}
	
	
	
}
