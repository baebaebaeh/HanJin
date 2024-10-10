package com.ssafy.movie;

import org.springframework.stereotype.Component;

// 이 태그의 역할 : 이 <bean>으로 관리하고 싶은 클래스에 붙여주면 된다.
@Component
public class Director {
	private String name = "빵찜";

	public String getName() {
		return name;
	}
	
}
