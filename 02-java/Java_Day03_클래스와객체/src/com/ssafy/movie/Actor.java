package com.ssafy.movie;

public class Actor {
	String name;
	int age;
	String gender;
	String agency;
	Actor() {}
	Actor(String name, int age, String gender, String agency) {
		if (age < 0) {
			System.out.println("나이는 0보다 크거나 같아야 합니다.");
			System.out.println("임시로 나이는 0으로 설정되었습니다.");
			age = 0;
		}
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.agency = agency;
	}
	void show() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("소속사 : " + agency);
	}
}










