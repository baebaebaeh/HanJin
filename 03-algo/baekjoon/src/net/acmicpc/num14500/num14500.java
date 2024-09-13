package net.acmicpc.num14500;

import java.util.*;

public class num14500 {

	static int N, M;
	static int[][] map;

	// 모든 가능한 테트로미노 모양 정의
	static int[][][] tetrominos = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, // I
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } }, // I 회전
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }, // O
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, // L
			{ { 0, 1 }, { 1, 1 }, { 2, 1 }, { 2, 0 } }, // L 대칭
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } }, // L 회전
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } }, // L 회전 대칭
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, // ㄴ
			{ { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, // ㄴ 대칭
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }, // ㄴ 회전
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } }, // ㄴ 회전 대칭
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, // S
			{ { 0, 1 }, { 1, 1 }, { 1, 0 }, { 2, 0 } }, // S 대칭
			{ { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 } }, // S 회전
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, // S 회전 대칭
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, // T
			{ { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, // T 회전
			{ { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, // T 회전
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } // T 회전
	};

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = s.nextInt();
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int[][] tetromino : tetrominos) {
					int sum = 0;
					boolean isValid = true;
					for (int[] block : tetromino) {
						int r = i + block[0];
						int c = j + block[1];
						if (r < 0 || r >= N || c < 0 || c >= M) {
							isValid = false;
							break;
						}
						sum += map[r][c];
					}
					if (isValid) {
						result = Math.max(result, sum);
					}
				}
			}
		}
		System.out.println(result);
	}
}