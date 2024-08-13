package com.swea.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea12712 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input12712.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// idx 짝수면 십자가 홀수면 X모양
			int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
			int d = 0;

			int max = 0; // 최댓값
			int sum1 = 0; // 십자가
			int sum2 = 0; // X모양
			
			// 모든 배열 돌리기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum1 = 0;
					sum2 = 0;
					// 모든 방향
					for (d = 0; d < 8; d++) {
						int nowR = r;
						int nowC = c;
						int sp = 0;
						// 범위 벗어나지 않고
						// while 반복횟수를 M - 1번까지돌림
						while (nowR + dr[d] >= 0 && nowR + dr[d] < N && 
								nowC + dc[d] >= 0 && nowC + dc[d] < N &&
								sp < M - 1) {
							nowR += dr[d];
							nowC += dc[d];
							// 십자가일땐 sum1 X모양이면 sum2
							if (d % 2 == 0) sum1 += map[nowR][nowC];
							if (d % 2 == 1) sum2 += map[nowR][nowC];
							// while 횟수 증가
							sp++;
						}
					}
					// 현재위치 더해주기
					sum1 += map[r][c];
					sum2 += map[r][c];
					// max랑 비교
					if (max < sum1) max = sum1;
					if (max < sum2) max = sum2;
				}
			}
			bw.write("#" + iter + " " + max + "\n");
		}
		bw.flush();
	}
}