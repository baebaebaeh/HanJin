package net.acmicpc;

import java.util.Scanner;

public class num2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int[] blackIdx = new int [N*2];
		for (int i = 0; i < N*2; i++) {
			blackIdx[i] = sc.nextInt();
		}
		for (int iter = 0; iter < N; iter++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					int blackX = blackIdx[iter*2];
					int blackY = blackIdx[iter*2+1];
					map[blackX + i][blackY + j] = 1;
				}
			}
		}
		int temp = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j<100; j++) {
				if (map[i][j] == 1) {
					temp++;
				}
			}
		}
		System.out.println(temp);
	}
}