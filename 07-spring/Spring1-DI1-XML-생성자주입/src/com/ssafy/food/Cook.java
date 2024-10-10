package com.ssafy.food;

public class Cook {
	private Ingredient ingredient;
//	public Cook() {
//		System.out.println("기본 cook");
//	}
	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
	
}
