
package com.ssafy.hw.day02.step02;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arrayFirst = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
//		for (int i=0; i<arrayFirst.length; i++) {
//			System.out.print(arrayFirst[i]);
//		}
		// 향상된 for문을 활용하자
		
		for (int i : arrayFirst) {
			System.out.print(i);
		}
		System.out.println(); //여기까지 숫자 나열
		
		
		
		int inputNum = sc.nextInt(); //숫자 받음
		
		String[] inputFood = new String[inputNum]; //inputFood의 배열 생성
		
		for (int i=0; i < inputNum; i++) {
		String inputFoodTemp = sc.next();
		inputFood[i] = inputFoodTemp;
		}
		
//		for (int i=0; i<inputFood.length; i++) {
//			System.out.println(inputFood[i]);
//		}
		
		for (int i=0; i<inputFood.length; i++) {
			System.out.println(inputFood[i]);
		}
		// 향상된 for문을 활용하자
		
	}
}
