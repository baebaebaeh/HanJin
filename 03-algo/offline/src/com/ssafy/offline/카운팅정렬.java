package com.ssafy.offline;

import java.util.Arrays;

public class 카운팅정렬 {
	public static void main(String[] args) {
		int [] data = {1, 9, 2, 2, 6, 4, 10}; // 카운팅정렬은 100만개 정도까지는 괜찮다.
		// 4바이트 * 100만 = 400만 바이트
		// 100만 바이트 = 1메가 바이트 총 4메가바이트 괜찮다
		countingSort(data);
		
	}
	static int[] countingSort(int[] data) {
		int[] count = new int[10+1];
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
		System.out.println(Arrays.toString(count));
		for (int i =1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		
//		System.out.println(Arrays.toString(data));
//		System.out.println(Arrays.toString(count));
		
		int[] dataSort = new int[data.length];
		// data배열의 뒤부터 가져온다.
		for (int i = data.length - 1; i >=0; i--) {
			
			dataSort[--count[data[i]]] = data[i];
		}
//		System.out.println(Arrays.toString(dataSort));
		return dataSort;
	}
}
