package com.ssafy.gt.user.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.gt.user.model.dto.Review;
import com.ssafy.gt.user.model.dto.Video;

public interface ReviewDAO {
	boolean addReview(Review review) throws SQLException;
	
	List<Review> findReviewById(String id) throws SQLException;
	
	boolean updateReview(String reviewNo, String reviewTitle, String reviewContent, String reviewScore) throws SQLException;
	
	boolean deleteReveiw(String reviewNo) throws SQLException;
}