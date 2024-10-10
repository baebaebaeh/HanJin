package com.ssafy.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		System.out.println("컨테이너 객체 생성 시작 - 설정파일 로딩..");
		ApplicationContext container = 
				new GenericXmlApplicationContext("food-config.xml");
		System.out.println("컨테이너 설정파일 로딩 끝...");
		// container.getBean("cook"); 얘는 object로 나온다.
		Cook cook = (Cook)container.getBean("cook");
		cook.display();
	}
}
