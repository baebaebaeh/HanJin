package com.ssafy.offline;
/*
 * 타입파라미터제한
 */
class WildBox<T> {}
class Fruit {}
class Apple extends Fruit {}
class Grape extends Fruit {}
public class GenericType4 {
	public static void main(String[] args) {
		WildBox<Fruit> fbox = new WildBox<>();
		WildBox<Apple> abox = new WildBox<>();
		WildBox<Grape> gbox = new WildBox<>();
//		fBox = aBox; //error
		WildBox<?> box1 = new WildBox<Fruit>();
		box1 = new WildBox<Apple>();
		box1 = new WildBox<Grape>();
		
		WildBox<? extends Fruit> box2 = new WildBox<Fruit>();
		box2 = new WildBox<Apple>();
		box2 = new WildBox<Grape>();
		
		// Fruit을 포함한 Fruit의 조상들 이외에는 타입파라미터를 제한한다.
		WildBox<? super Fruit> box3 = new WildBox<Fruit>(); 
//		box2 = new WildBox<Apple>(); //error
//		box2 = new WildBox<Grape>();
	}
}
