package com.ssafy.hw.day04.step04;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	String pCode;
	String writer;
	String content;
	

	public Review(int reviewId, String pCode, String writer, String content) {
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
}
