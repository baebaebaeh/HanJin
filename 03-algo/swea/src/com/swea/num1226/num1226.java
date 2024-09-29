package com.swea.num1226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class num1226 {
	static int[][] map = new int[16][16];
	static int[] start = new int[2];
	static int[] end = new int[2];
	static Queue<int[]> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		for (int TC = 1; TC <= 10; TC++) {
			br.readLine();
			for (int r = 0; r < 16; r++) {
				String st = br.readLine();
				for (int c = 0; c < 16; c++) {
					int temp = st.charAt(c) - '0';
					map[r][c] = temp;
					if (temp == 2) {
						start[0] = r;
						start[1] = c;
					}
					if (temp == 3) {
						end[0] = r;
						end[1] = c;
					}
				}
			}
			//
			if (bfs()) {
				bw.write("#" + TC + " 1\n");
			} else {
				bw.write("#" + TC + " 0\n");
			}
		}
		bw.flush();

	}

	static boolean bfs() {
		q = new ArrayDeque<>();
		int sr = start[0];
		int sc = start[1];
		q.add(new int[] {sr, sc});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 &&
						map[nr][nc] != 1) {
					if (map[nr][nc] == 3) {
						return true;
					}
					q.add(new int[] {nr, nc});
					map[nr][nc] = 1;
				}
			}
		}
		return false;
	}
}