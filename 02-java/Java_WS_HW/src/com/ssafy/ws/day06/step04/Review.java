package com.ssafy.ws.day06.step04;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	String resId;
	String writer;
	int content;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, String resId, String writer, int content) {
		super();
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", resId=" + resId + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
	
}
