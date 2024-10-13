package com.ssafy.gt.user.model.dto;

public class Review {
	private String reviewNo;
	private String reviewId;
	private String reviewUserName;
	private String reviewTitle;
	private String reviewContent;
	private String reviewScore;
	private String reviewEmail;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String reviewNo, String reviewId, String reviewUserName, String reviewTitle, String reviewContent,
			String reviewScore, String reviewEmail) {
		super();
		this.reviewNo = reviewNo;
		this.reviewId = reviewId;
		this.reviewUserName = reviewUserName;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewEmail = reviewEmail;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewId=" + reviewId + ", reviewUserName=" + reviewUserName
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", reviewScore=" + reviewScore
				+ ", reviewEmail=" + reviewEmail + "]";
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewUserName() {
		return reviewUserName;
	}
	public void setReviewUserName(String reviewUserName) {
		this.reviewUserName = reviewUserName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewEmail() {
		return reviewEmail;
	}
	public void setReviewEmail(String reviewEmail) {
		this.reviewEmail = reviewEmail;
	}
	
}
