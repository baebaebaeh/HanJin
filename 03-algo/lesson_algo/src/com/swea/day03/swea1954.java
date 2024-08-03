package com.swea.day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1954 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("data/input1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int iter = 0; iter < T; iter++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int num = 0;
			// 초기 map
			int[][] map = new int[N][N];
			// 현재위치
			int nowRow = 0;
			int nowCol = 0;
			// 방향
			// 우0 하1 좌2 상3
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int d = 0;
			while (num < N * N) {
				if (nowRow + dr[d] < N && nowRow + dr[d] >= 0 && nowCol + dc[d] < N && nowCol + dc[d] >= 0
						&& map[nowRow + dr[d]][nowCol + dc[d]] == 0) {
					num++;
					map[nowRow][nowCol] = num;
					nowRow += dr[d];
					nowCol += dc[d];
					continue;
				}
				d++;
				d = d % 4;
				num++;
				map[nowRow][nowCol] = num;
				nowRow += dr[d];
				nowCol += dc[d];
			}
			bw.write("#" + (iter + 1) + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bw.write(Integer.toString(map[i][j]) + " ");
				}
				bw.write("\n");
			}
			bw.flush();
		}
	}
}