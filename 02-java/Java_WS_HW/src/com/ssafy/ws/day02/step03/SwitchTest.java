package com.ssafy.ws.day02.step03;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// off : 0 설정
		int[] data = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int idx = sc.nextInt();  // 3, 5, 2
			for (int j = idx; j <= n; j += idx) {
				data[j] = 1 - data[j];
			}
		}
		
		for (int i = 1; i < n + 1; i++) {
			System.out.print(data[i] + " ");
		}
	}
}





