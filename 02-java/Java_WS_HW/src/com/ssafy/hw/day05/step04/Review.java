package com.ssafy.hw.day05.step04;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	String pCode;
	String writer;
	String content;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, String pCode, 
			String writer, String content) {
		super();
		this.reviewId = reviewId;
		this.pCode = pCode;
		this.writer = writer;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", pCode=" + pCode + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	int getReviewId() {
		return reviewId;
	}
	void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	String getpCode() {
		return pCode;
	}
	void setpCode(String pCode) {
		this.pCode = pCode;
	}
	String getWriter() {
		return writer;
	}
	void setWriter(String writer) {
		this.writer = writer;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
	}
	
	
	
}
