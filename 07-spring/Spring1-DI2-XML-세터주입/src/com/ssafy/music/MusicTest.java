package com.ssafy.music;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MusicTest {
	public static void main(String[] args) {
		/*
		  Artist 클래스 정의
		  name 속성
		  생성자를 통해서 설정
		  
		  Album 클래스 정의
		  Artist 속성
		  생성자를 통해서 설정
		  displayt : 앨범의 가수 정보를 출력
		  
		  위 두 클래스를 xml에 빈으로 설정
		  객체의 의존성은 생성자 주입으로 처리
		  
		  main 메서드에서는
		  컨테이너 객체를 생성하고 music-config.xml 파일을 로딩시킨다.
		  등록된 빈중에서 album 빈을 찾고 display메서드를 호출
		 */
		ApplicationContext container = new GenericXmlApplicationContext("music-config.xml");
		for (String beanName : container.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		Album album1 = (Album)container.getBean("album");
		album1.display();
	}
}
