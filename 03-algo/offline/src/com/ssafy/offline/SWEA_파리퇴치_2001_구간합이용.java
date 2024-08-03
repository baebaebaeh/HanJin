package com.ssafy.offline;

import java.util.Scanner;

public class SWEA_파리퇴치_2001_구간합이용 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N + 1][N + 1];
			int max = 0;

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					int item = sc.nextInt();
					map[i][j] = item + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
				}
			}

			for (int i = M; i < N + 1; i++) {
				for (int j = M; j < N + 1; j++) {
					int sum = map[i][j] - map[i][j - M] - map[i - M][j] + map[i - M][j - M];
					if (sum > max)
						max = sum;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}