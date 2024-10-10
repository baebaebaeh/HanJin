package com.ssafy.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("board-config.xml");
		for (String beanName : container.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		BoardController controller = container.getBean("boardController", BoardController.class);
		controller.addBoard("게시판 등록완료");
	}
}
