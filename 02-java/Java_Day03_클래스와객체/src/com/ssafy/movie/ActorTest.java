package com.ssafy.movie;

public class ActorTest {
	public static void main(String[] args) {
		// 차은우
		Actor a1 = new Actor();
		a1.name = "차은우";
		a1.age = 28;
		a1.gender = "남성";
		a1.agency = "판타지오";
		a1.show();
		
		// 박보영
		Actor a2 = new Actor("박보영", 34, "여성", "BH");
		a2.show();
	}
}
