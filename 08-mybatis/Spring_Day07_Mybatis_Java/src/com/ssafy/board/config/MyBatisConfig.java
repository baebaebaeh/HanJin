package com.ssafy.board.config;

import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisConfig {
	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	public static void main(String[] args) {
		Math.random();
	}
}