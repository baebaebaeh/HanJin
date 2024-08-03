package com.ssafy.ws.day02.step01;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		// 크기가 4인 정수형 배열을 선언해보자.
		int[] birthday = new int[4];
		// 각각의 인덱스에 접근하여 값을 생일로 바꾸어보자.
		// ex) 생일 6월 7일 -> 0607 로 생각하기
		birthday[0] = 0; //생략 가능
		birthday[1] = 6;
		birthday[2] = 0; //생략 가능
		birthday[3] = 7;
		
		System.out.println(birthday);
		System.out.println(Arrays.toString(birthday));
		
		// 우리반 동기 3명의 이름을 원소로 같은 String 배열을 선언하고 초기화 해보자.
		String[] names = {"승호", "규리", "혜준"};
		
		System.out.println(Arrays.toString(names));
	}
}

















