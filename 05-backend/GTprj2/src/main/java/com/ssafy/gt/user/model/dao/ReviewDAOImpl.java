package com.ssafy.gt.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.gt.user.model.dto.Review;
import com.ssafy.gt.user.model.dto.User;
import com.ssafy.gt.user.model.dto.Video;
import com.ssafy.gt.util.DBUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private ReviewDAOImpl() {}
	private static ReviewDAO instance = new ReviewDAOImpl();
	public static ReviewDAO getInstance() {
		return instance;
	}
	@Override
	public boolean addReview(Review review) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String videoId = review.getReviewId();
		String reviewTitle = review.getReviewTitle();
		String reviewContent = review.getReviewContent();
		String reviewScore = review.getReviewScore();
        String reviewEmail = review.getReviewEmail();
        String reviewUserName = review.getReviewUserName();
        
		String sql = "insert into tb_review(\r\n"
				+ "	review_id,\r\n"
				+ "	review_title, \r\n"
				+ "	review_content, \r\n"
				+ "	review_score,\r\n"
				+ "	review_email,\r\n"
				+ "	review_user_name\r\n"
				+ ") values (\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?\r\n"
				+ ");\r\n"
				+ "SET @videoreviewcnt = (SELECT video_reviewcnt FROM tb_video WHERE video_id = ?);\r\n"
				+ "UPDATE tb_video SET video_reviewcnt = @videoreviewcnt + 1 WHERE video_id = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, videoId);
		pstmt.setString(2, reviewTitle);
		pstmt.setString(3, reviewContent);
		pstmt.setString(4, reviewScore);
		pstmt.setString(5, reviewEmail);
		pstmt.setString(6, reviewUserName);
		pstmt.setString(7, videoId);
		pstmt.setString(8, videoId);
		pstmt.executeUpdate();
		return true;
	}
	@Override
	public List<Review> findReviewById(String id) throws SQLException {
		List<Review> reviews = new ArrayList<>();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "SELECT * FROM tb_review WHERE review_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Review review = new Review();
			review.setReviewNo(rs.getString("review_no"));
			review.setReviewId(id);
			review.setReviewTitle(rs.getString("review_title"));
			review.setReviewContent(rs.getString("review_content"));
			review.setReviewScore(rs.getString("review_score"));
			review.setReviewEmail(rs.getString("review_email"));
			review.setReviewUserName((rs.getString("review_user_name")));
			reviews.add(review);
		}
		return reviews;
	}
	@Override
	public boolean updateReview(String reviewNo, String reviewTitle, String reviewContent, String reviewScore)
			throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "update tb_review\r\n"
				+ "set review_title = ?, review_content = ?, review_score = ?\r\n"
				+ "where review_no = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, reviewTitle);
		pstmt.setString(2, reviewContent);
		pstmt.setString(3, reviewScore);
		pstmt.setString(4, reviewNo);
		pstmt.executeUpdate();
		return true;
	}
	@Override
	public boolean deleteReveiw(String reviewNo) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "delete from tb_review\r\n"
				+ "where review_no = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, reviewNo);
		pstmt.executeUpdate();
		return true;
	}
	
}
