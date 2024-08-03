package com.ssafy.hw.day02.step04;

import java.util.Scanner;

public class ProductValue {

	public static void main(String[] args) {

		// scan, 초기설정
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] price = new int[N];
		int[] rank = new int[N]; // 등수 저장할 공간
		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		}

		// 값 비교 (각 요소의 다음 인덱스와 비교하여 값이 작으면 등수 더해주기)
		for (int i = 0; i < N; i++) { 
			for (int j = 1; i + j < N; j++) {
				if (price[i] > price[i + j]) {
					rank[i+j] += 1;
				} else {
					rank[i] += 1;
				}
			}
		}
		for (int A : rank)
		System.out.print(A+1 + " "); // 등수는 1등부터 시작이라 A+1
	}
}
