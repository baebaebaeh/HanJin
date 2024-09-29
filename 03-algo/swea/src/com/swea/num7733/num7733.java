package com.swea.num7733;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class num7733 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, count, ans;
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for (int day = 0; day <= 100; day++) {
				count = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] == day) {
							map[r][c] = 0;
						}
					}
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (visited[r][c] || map[r][c] == 0) {
							continue;
						}
						bfs(r, c);
						count++;
					}
				}
				if (ans < count) {
					ans = count;
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						visited[r][c] = false;
					}
				}
				
				
			}
			bw.write("#" + testCase + " " + ans + "\n");
		}
		bw.flush();
	}
	private static void bfs(int row, int col) {
		q.add(new int[] { row, col });
		visited[row][col] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && 
						map[nr][nc] != 0 && !visited[nr][nc]) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}













