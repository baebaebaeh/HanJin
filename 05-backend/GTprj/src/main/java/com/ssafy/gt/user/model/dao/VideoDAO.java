package com.ssafy.gt.user.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.gt.user.model.dto.Video;

public interface VideoDAO {
	
	Video searchById(String id) throws SQLException;

	boolean add(Video video) throws SQLException;
	
	List<Video> selectAll() throws SQLException;
	
	boolean viewCntUp(String videoId) throws SQLException;
	
	boolean viewCntDown(String videoId) throws SQLException;
	
}