package com.ssafy.hw.day03.step02;

/**
 * 2차원 배열 탐색 연습하기
 * 
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 * 
 * 2차원 배열은 각 배열의 요소로 1차원 배열을 갖는 배열입니다.
 * 
 * 1차원 배열을 탐색하기 위해서 하나의 반복문이 필요했습니다.
 * 2차원 배열을 탐색하기 위해서 두 개의 반복문이 필요합니다.
 * 
 */
public class LoopAndArray2 {
	
	public static void main(String[] args) {
		
		// Q. 5행 6열 크기를 갖는 int형 nuberList 배열을 생성해 봅시다.
		int[][] numberList = new int[5][6];
		
		// Q. (0, 0), (0, 1), (0, 2) ... (0, 5) (1, 0), (1, 1) ... (4, 4) 까지
		//    10부터 1씩 증가하여 저장해 봅시다.
		
		int num = 10;
		
		for(int rowIdx = 0; rowIdx < numberList.length; rowIdx++) {
			for(int colIdx = 0; colIdx < numberList[rowIdx].length; colIdx++) {
				numberList[rowIdx][colIdx] = num++;
			}
		}
		
		System.out.println("numberList 출력");
		for(int rowIdx = 0; rowIdx < numberList.length; rowIdx++) {
			for(int colIdx = 0; colIdx < numberList[rowIdx].length; colIdx++) {
				System.out.print(" " + numberList[rowIdx][colIdx]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Q. (0, 0), (1, 0), (2, 0) ... (5, 0), (0, 1), (1, 1), (2, 1) ... (4, 4) 까지
		//    10부터 1씩 증가하여 저장해 봅시다.
		
		num = 10;
		
		for(int colIdx = 0; colIdx < numberList[0].length; colIdx++) {
			for(int rowIdx = 0; rowIdx < numberList.length; rowIdx++) {
				numberList[colIdx][rowIdx] = num++;
			}
		}
		
//		System.out.println("numberList 출력");
//		for(int rowIdx = 0; rowIdx < ____.length; rowIdx++) {
//			for(int colIdx = 0; colIdx < ____.length; colIdx++) {
//				System.out.print(" " + numberList[____][____]);
//			}
//			System.out.println();
//		}
		
	}
}