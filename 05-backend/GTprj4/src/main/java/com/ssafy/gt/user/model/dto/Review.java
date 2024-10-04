package com.ssafy.gt.user.model.dto;

public class Review {
	private String reviewId;
	private String reviewTitle;
	private String reviewContent;
	private String reviewScore;
	private String reviewEmail;
	public Review() {}
	public Review(String reviewTitle, String reviewId, String reviewContent, String reviewScore, String reviewEmail) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewEmail = reviewEmail;
	}
	@Override
	public String toString() {
		return "Review [reviewTitle=" + reviewTitle + ", reviewId=" + reviewId + ", reviewContent=" + reviewContent
				+ ", reviewScore=" + reviewScore + ", reviewEmail=" + reviewEmail + "]";
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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
