package net.acmicpc.num2206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2206 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map;

	static int tempAns, N, M;
	static int ans = 99999999;
	static List<int[]> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input2206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = string.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		dfs(0, 0, 1, 1, visited);
		if (ans == 99999999)
			ans = -1;
		bw.write(ans + "");
		bw.flush();
	}

	private static void dfs(int r, int c, int i, int num, boolean[][] visited) {

		for (int d = 0; d < 4; d++) {
			int row = r + dr[d];
			int col = c + dc[d];
			if (row < 0 || row >= N || col < 0 || col >= M) {
				continue;
			}
			if (map[row][col] == 1) {
				i -= 1;
				if (i < 0) {
					i++;
					continue;
				}
			}
			if (visited[row][col]) {
				continue;
			}
			visited[row][col] = true;
			if (row == N - 1 && col == M - 1) {
				num += 1;
				if (ans > num) {
					ans = num;
				}
				visited[row][col] = false;
				num--;
				continue;
			}
			num += 1;
			dfs(row, col, i, num, visited);
			visited[row][col] = false;
			num--;
		}
	}
}