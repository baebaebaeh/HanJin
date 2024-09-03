package net.acmicpc.num1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class num1952 {
	static int[][] map;
	static boolean[][] visited;
	static int maxDay, N, day, ans, tempAns;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			maxDay = 0;
			ans = 0;
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (maxDay < map[i][j]) {
						maxDay = map[i][j];
					}
				}
			}
			for (day = 0; day < maxDay; day++) {
				tempAns = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						bfs(i, j);
					}
				}
				if (tempAns > ans) ans = tempAns;
				for (int j = 0; j < N; j++) {
					Arrays.fill(visited[j], false);
				}
			}
			System.out.println("#" + iter + " " + ans);
		}
	}

	private static void bfs(int R, int C) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { R, C });
		if (visited[R][C] || map[R][C] <= day) {
			return;
		}
		visited[R][C] = true;
		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] > day && !visited[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new int[] { nr, nc });
						}
					}
				}				
			}
		}
		tempAns++;
	}
}