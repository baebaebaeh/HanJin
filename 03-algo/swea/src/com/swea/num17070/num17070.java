package com.swea.num17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17070 {
	static int[][] map;
	static int[][] count;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0}; // 우 우하 하
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(count[N-1][N-1]); 
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 1, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int dir = now[2];
			for (int d = 0; d < 3; d++) {
				if (dir == 0 && d == 2) {
					continue;
				}
				if (dir == 2 && d == 0) {
					continue;
				}
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || 
						map[nr][nc] == 1) {
					continue;
				}
				if (d == 1 && (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1)) {
					continue;
				}
				int[] next = new int[] {nr, nc, d};
				q.add(next);
				count[nr][nc]++;
			}
		}
	}
}










