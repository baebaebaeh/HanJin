package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.board.controller.BoardController;
import com.ssafy.config.AopConfig;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext container = null;
//		container = new GenericXmlApplicationContext("board-config.xml");
		container = new AnnotationConfigApplicationContext(AopConfig.class);
		BoardController boardController = (BoardController)container.getBean("boardController");
		boardController.addBoard("AOP 성공...");
	}
}
