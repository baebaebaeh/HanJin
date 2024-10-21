package com.ssafy.reflection;

import java.util.ArrayList;
import java.util.Random;

/*
	[1. 클래스 정보 접근]
	2. 메서드 정보 접근
	3. 객체 생성과 메서드 실행
 */
public class reflectionTest1 {
	public static void main(String[] args) throws Exception {
		// 클래스 정보를 접근하는 3가지 방법
		/*
		 *  1. 클래스이름.class
		 *  2. 객체.getClass()
		 *  3. Class.forName(패키지.클래스이름)
		 */
		// .class
		Class<?> clz1 = Dog.class;
		// 객체생성 후 .getClass()
		Dog dog = new Dog();
		Class<?> clz2 = dog.getClass();
		// Class.forName()
		Class<?> clz3 = Class.forName("com.ssafy.reflection.Dog");
		
		// 클래승
		
		// 셋다 같은 주소를 가지고 있다.
		System.out.println(clz1 == clz2);
		System.out.println(clz2 == clz3);
		
		System.out.println(clz1.getSimpleName());
		System.out.println(clz1.getName());
		Object obj = getRandomObject();
		Class<?> clz = obj.getClass();
		System.out.println(clz.getName());
		switch (clz.getName()) {
			case "java.lang.String":
			case "java.util.ArrayList":
		}
	}
	
	private static Object getRandomObject() throws Exception {
		Object[] arr = {
				new String("a"),
				new Dog(),
				new ArrayList<>()
		};
		return arr[new Random().nextInt(arr.length)];
	}
}
