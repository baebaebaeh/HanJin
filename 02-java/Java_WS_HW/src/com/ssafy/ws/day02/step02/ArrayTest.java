package com.ssafy.ws.day02.step02;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		// 코드를 작성하세요.
		int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		/*
		for (int v : nums) {
			System.out.print(v);
		}
		*/
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] food = new String[n];
		for (int i = 0; i < n; i++) {
			food[i] = sc.next();
		}
		for (String f : food) {
			System.out.println(f);
		}
	}
}














