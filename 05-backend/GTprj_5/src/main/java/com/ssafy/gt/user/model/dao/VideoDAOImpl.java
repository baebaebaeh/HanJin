package com.ssafy.gt.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.gt.user.model.dto.User;
import com.ssafy.gt.user.model.dto.Video;
import com.ssafy.gt.util.DBUtil;

public class VideoDAOImpl implements VideoDAO {
	private VideoDAOImpl() {}
	private static VideoDAO instance = new VideoDAOImpl();
	public static VideoDAO getInstance() {
		return instance;
	}
	@Override
	public Video searchById(String id) throws SQLException {
		Video video = new Video();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "select * from tb_video where video_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) {
			System.out.println(11);
		} else {
			String videoId = rs.getString("video_id");
			String videoTitle = rs.getString("video_title");
			String videoPart = rs.getString("video_part");
			String channelName = rs.getString("channel_name");
			int videoViewcnt = rs.getInt("video_viewcnt");
			String videoLength = rs.getString("video_length");
			int videoReviewcnt = rs.getInt("video_reviewcnt");
			video.setVideoId(videoId);
			video.setVideoTitle(videoTitle);
			video.setVideoPart(videoPart);
			video.setChannelName(channelName);
			video.setVideoViewcnt(videoViewcnt);
			video.setVideoLength(videoLength);
			video.setVideoReviewcnt(videoReviewcnt);
		}
		return video;
	}
	@Override
	public boolean add(Video video) throws SQLException {
		String id = video.getVideoId();
		String title = video.getVideoTitle();
		String part = video.getVideoPart();
		String channelName = video.getChannelName();
		int viewCnt = video.getVideoViewcnt();
		String length = video.getVideoLength();
		int reviewCnt = video.getVideoReviewcnt();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "INSERT INTO tb_video (\r\n"
				+ "	   video_id,\r\n"
				+ "    video_title,\r\n"
				+ "    video_part,\r\n"
				+ "    video_length,\r\n"
				+ "    channel_name\r\n"
				+ ") VALUES (\r\n"
				+ "	   ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?\r\n"
				+ ");";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, title);
		pstmt.setString(3, part);
		pstmt.setString(4, length);
		pstmt.setString(5, channelName);
		return true;
	}
	@Override
	public List<Video> selectAll() throws SQLException {
		List<Video> videos = new ArrayList<>();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "SELECT * FROM tb_video;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Video video = new Video();
			String videoId = rs.getString("video_id");
			String videoTitle = rs.getString("video_title");
			String videoPart = rs.getString("video_part");
			String channelName = rs.getString("channel_name");
			int videoViewcnt = rs.getInt("video_viewcnt");
			String videoLength = rs.getString("video_length");
			int videoReviewcnt = rs.getInt("video_reviewcnt");
			video.setVideoId(videoId);
			video.setVideoTitle(videoTitle);
			video.setVideoPart(videoPart);
			video.setChannelName(channelName);
			video.setVideoViewcnt(videoViewcnt);
			video.setVideoLength(videoLength);
			video.setVideoReviewcnt(videoReviewcnt);
			videos.add(video);
		}
		return videos;
	}
	@Override
	public boolean reviewCntUp(String videoId) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "SET @viewcnt = (SELECT video_viewcnt FROM tb_video WHERE video_id = ?);\r\n"
				+ "\r\n"
				+ "UPDATE tb_video \r\n"
				+ "SET video_viewcnt = @viewcnt + 1 \r\n"
				+ "WHERE video_id = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, videoId);
		pstmt.setString(2, videoId);
		pstmt.executeUpdate();
		return true;
	}
	
	
}
