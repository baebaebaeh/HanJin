package com.ssafy.ws.day04.step04;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	public Review(int reviewId, int resId, String writer, String content) {
		super();
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}
	
	public Review() {
		super();
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", resId=" + resId + ", writer=" + writer + ", content=" + content
				+ "]";
	}
}
