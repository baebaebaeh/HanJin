package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 5시32분
class sweaTest {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/inputTest.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int room = 0;
			// 경비원 좌표
			int row = 0;
			int col = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) room += 1;
					if (map[i][j] == 2) {
						row = i;
						col = j;
					}
				}
			}
			// 상0  하1  좌2  우3
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int d = 0;
			for (d = 0; d < 4; d++) {
				int tempRow = row;
				int tempCol = col;
				while (tempRow + dr[d] >= 0 && tempRow + dr[d] < N &&
						tempCol + dc[d] >= 0 && tempCol + dc[d] < N &&
						map[tempRow + dr[d]][tempCol + dc[d]] == 0) {
					room -= 1;
					tempRow += dr[d];
					tempCol += dc[d];
				}
			}
			bw.write("#" + iter + " " + room + "\n");
		}
		bw.flush();
	}
}