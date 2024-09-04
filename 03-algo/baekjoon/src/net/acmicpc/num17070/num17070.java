package net.acmicpc.num17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17070 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	static int N, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}
		if (dir == 0) {
			for (int d = 0; d < 2; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
					if (d == 1) {
						if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
							continue;
						}
					}
					dfs(nr, nc, d);
				}
			}
		}
		if (dir == 1) {
			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
					if (d == 1) {
						if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
							continue;
						}
					}
					dfs(nr, nc, d);
				}
			}
		}
		if (dir == 2) {
			for (int d = 1; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
					if (d == 1) {
						if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
							continue;
						}
					}
					dfs(nr, nc, d);
				}
			}
		}
	}
}
