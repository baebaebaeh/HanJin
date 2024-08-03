package com.ssafy.ws.day04.step01;

import java.util.Scanner;

/**
 * 클래스 개념 익히기
 * 
 * 객체 지향 프로그래밍(OOP, Object-Oriented Programming)은
 * 데이터를 객체(Object)로 취급하고 중심이 되는 프로그래밍 방식입니다.
 * 
 * 우리가 인식할 수 있는 모든 것을 객체로 표현할 수 있습니다.
 * 이러한 객체는 속성과 동작이 포함되어있습니다.
 * 
 */
public class ClassConcept {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ans = Math.max(100, 20);
		
		int n = sc.nextInt();
		
		System.out.println("클래스는 관련 있는 변수와 함수를 묶어서 만든 사용자 정의 자료형 입니다.");
		System.out.println("클래스의 속성(Attribute) == 멤버필드");
		System.out.println("클래스의 동작(Behavior) == 메서드");
		System.out.println("클래스를 통해 생성된 객체를 인스턴스 라고 합니다.");
		System.out.println("클래스 선언 방법은 [접근제한자] [활용제한자] class 클래스이름 { ... } 과 같은 형식입니다.");
		System.out.println("사람을 객체로 표현 했을 때, 사람의 이름, 나이, 취미 같은 것들은 멤버필드 라고 할 수 있습니다.");
		System.out.println("사람을 객체로 표현 했을 때, 자기 소개를 한다, 공부를 한다 같은 것들은 메서드 라고 할 수 있습니다.");
		//                                 public     static    void    main    (String[] args)
		System.out.println("메서드 선언 방법은 [접근제한자] [활용제한자] [반환타입] 메서드이름 ( [매개변수] ) { ... } 과 같은 형식입니다. ");
		System.out.println("반환타입은 메서드를 선언할 때 지정되고, 없으면 void 가 됩니다.");
		System.out.println("메서드를 호출하기 위해서는 메서드가 선언되어 있는 클래스에 접근해야 합니다.");
		/*
		 	Scanner sc = new Scanner(System.in);
		 	sc.nextInt();
		 	
		 	Math.max(10, 20);
		 	
		 	메서드에 static 이 선언되어 있다면 "클래스(멤버) 메서드"
		 	메서드에 static 이 선언되어 있지 않다면 "인스턴스(멤버) 메서드"
		 */
		System.out.println("메서드를 호출하는 방법은 클래스/객체이름.메서드이름( [인자] ) 과 같은 형식으로 호출합니다.");
		System.out.println("생성자는 객체를 생성할때 실행되는 메서드 입니다. new 키워드와 함께 호출되며 클래스 이름과 동일합니다.");
		/*
			class Bread {
				void Bread() {}
				// Bread(String name) {}
			}
			Bread b2 = new Bread();

			//Bread b = new Bread("소보로");
			//b.getPrice();
		 */
		System.out.println("생성자는 반환타입을 갖지 않으며, 객체가 생성될 때 반드시 호출됩니다. 만약 하나도 정의되어 있지 않다면 default 생성자가 호출됩니다.");
		System.out.println("this는 참조 변수로써 객체 자신을 가리킵니다.");
	}
	
}
















