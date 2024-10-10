package com.ssafy.food;

public class Cook {
	private Ingredient ingredient;
	
	// 아래가 생성자에서 바뀜
	// 차이점 비교해보자
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
	
}
