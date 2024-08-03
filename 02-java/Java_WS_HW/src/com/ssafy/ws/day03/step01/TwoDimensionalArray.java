package com.ssafy.ws.day03.step01;

/**
 * 2차원 배열 연습하기
 * 
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 * 
 * 2차원 배열은 각 배열의 요소로 1차원 배열을 갖는 배열입니다.
 * 
 */
public class TwoDimensionalArray {
	
	public static void main(String[] args) {
		
		/* 2차원 배열 연습하기 */
		
		// Q. 2행 2열의 크기를 갖는 int형 데이터를 저장할 수 있는 numberList 배열을 생성해 봅시다.
		int[][] numberList = new int[2][2];
		
		// Q. (0, 0)에 10
		//    (0, 1)에 20
		//    (1, 0)에 30
		//    (1, 1)에 40
		//    을 저장해 봅시다.
		
		numberList[0][0] = 10;
		numberList[0][1] = 20;
		numberList[1][0] = 30;
		numberList[1][1] = 40;
		
		
		// Q. (0, 0)에 저장된 값과 (1, 0)에 저장된 값을 곱한 결과를 출력해 봅시다.
		System.out.println("(0, 0) * (1, 0) = " + numberList[0][0] * numberList[1][0]);
		
		// Q. 3행 3열의 크기를 갖는 int형 데이터를 저장할 수 있는 numberList2 배열을 생성해 봅시다.
		//    배열을 생성하면서 아래의 그림 처럼 데이터를 저장할 수 있도록 선언과 동시에 초기화를 해봅시다.
		//    1 2 3
		//    4 5 6
		//    7 8 9
		int[][] numberList2 = {
				{1, 2, 3}, 
				{4, 5, 6}, 
				{7, 8, 9}
		};
		
		// Q. (0, 1)에 저장된 값과 (1, 0)에 저장된 값을 곱한 결과를 출력해 봅시다.
		System.out.println("(0, 1) * (1, 0) = " + numberList2[0][1] * numberList2[1][0]);
	}
}




