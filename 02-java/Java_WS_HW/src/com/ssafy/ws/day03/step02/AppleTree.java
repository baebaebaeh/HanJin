package com.ssafy.ws.day03.step02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AppleTree {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/Appletree.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dr = {0, 0, -1, 1};
		int[] dc = {1, -1, 0, 0};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = map[i][j];
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						sum += map[nr][nc];
					}
				}
				ans = Math.max(ans, sum);
			}
		}
		
		
//		System.out.println(Arrays.toString(map));
//		System.out.println(Arrays.deepToString(map));
		System.out.println(ans);
	}
}









