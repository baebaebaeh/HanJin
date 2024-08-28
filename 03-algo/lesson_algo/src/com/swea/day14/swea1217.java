package com.swea.day14;

import java.util.Scanner;

class swea1217 {
	static int N;
	static int M;
	static int ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int TC = 1; TC <= 10; TC++) {
			ans = 1;
			sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			sq(0);
			System.out.println("#" + TC + " " + ans);
		}
	}
	private static void sq(int iter) {
		if (iter == M) {
			return;
		}
		ans *= N;
		sq(iter + 1);
	}

}
