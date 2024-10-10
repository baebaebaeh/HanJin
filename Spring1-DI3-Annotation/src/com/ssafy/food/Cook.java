package com.ssafy.food;

import org.springframework.beans.factory.annotation.Autowired;
// 모든 annotation 막고 실행해도 실행이 된다. 왜 why
// 생성자가 하나밖에 없으면 그 생성자를 실행해준다. 4.3버전부터
// 그래서 set주입도 없애주면 된다.
// 맴버변수는 final이 기본이다.
// final은 초기값 설정을 해야하는데 생성자로 설정하면 초기값설정 안해도 된다.
// 따라서 아래와 같이 사용하게 된다.
// 두가지중 하나를 골라서 사용한다. final없애고 필드주입하던가 final넣고 생성자주입사용하던가
public class Cook {
	// ingredient객체를 컨테이너가 관리해야지 자동주입해준다.
	// 해석해서 처리해 줄 수 있도록 xml에 주입관련 어노테이션을 해석해달라고 요청해야한다.
	// 필드주입
//	@Autowired 
	private final Ingredient ingredient;
	
	// annotation은 3가지 주입이 가능하다
	// 생성자 주입
//	@Autowired
	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	// 기본 객체 생성할때 Autowired가 있고 ingredient가 container에 있으면
	// 자동으로 실행해 준다.
	// set주입
//	@Autowired
//	public void setIngredient(Ingredient ingredient) {
//		this.ingredient = ingredient;
//	}
	
	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
	
}
