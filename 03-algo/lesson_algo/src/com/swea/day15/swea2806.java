package com.swea.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class swea2806 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][] map;
	static int N;
	static int[] dr = { 0, -1, -1, -1 };
	static int[] dc = { -1, -1, 0, 1 };
	static int queen, ans;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input2806.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					queen = 0;
					map = new int[N][N];
					check(i, j);					
				}
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}

	private static void check(int r, int c) {

		// 좌 좌상 상 우상 찾아보고 퀸 놓을 수 없으면
		for (int d = 0; d < 4; d++) {
			int row = r;
			int col = c;
			while (row + dr[d] >= 0 && col + dc[d] >= 0 && col + dc[d] < N) {
				row += dr[d];
				col += dc[d];
				if (map[row][col] == 1) {
					return;
				}
			}
		}
		// 현재 위치 1로 만들고
		map[r][c] = 1;
		queen++;
		if (queen == N) {
			ans++;
			queen--;
			return;
		}
		while(!(r == N - 1 && c == N - 1)) {
			c += 1;
			if (c / N == 1) {
				r += 1;
				c = 0;
				check(r, c);
			} else {
				check(r, c);
			}			
		}
	}
}