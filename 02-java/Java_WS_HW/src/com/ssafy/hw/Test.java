package com.ssafy.hw;

class Animal {}
class Cat extends Animal {}
class Dog extends Animal {}
public class Test {
	public static void main(String[] args) {
		Animal a = new Dog();
//		Dog d = new Animal();  // 컴파일 에러
//		Dog d = a;   // 컴파일 에러
		Dog d = (Dog)a;
		
		Animal a2 = new Cat();
		Dog d2 = (Dog)a2;  // ClassCastException
	}
}



















