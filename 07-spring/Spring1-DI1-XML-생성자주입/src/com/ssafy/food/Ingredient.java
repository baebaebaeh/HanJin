package com.ssafy.food;

public class Ingredient {
	// 필드주입 생성자주입 세터주입 세가지중 하나이다.
	// 밑은 생성자 주입
	private String name;
//	public Ingredient() {
//		System.out.println("기본 ingredient");
//	}
	public Ingredient(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
