package net.acmicpc.num17822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17822 {
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static float count = 0;
	static float sum = 0;
	static int N;
	static int M;
	static int T;
	static int x;
	static int d;
	static int k;
	static boolean change;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input17822.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		count = N * M;
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		change = false;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // 배수
			d = Integer.parseInt(st.nextToken()); // 방향
			k = Integer.parseInt(st.nextToken()); // 몇번
			if (d == 0) {
				k = M - k;
			}
			rotate();
			change = false;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					zero(r, c);
				}
			}
			if (!change) {
				Float a = sum / count;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (map[r][c] != -10000 && map[r][c] > a) {
							map[r][c]--;
							sum--;
						} else if (map[r][c] != -10000 && map[r][c] < a) {
							map[r][c]++;
							sum++;
						}
					}
				}
			}
		}
		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != -10000)
					ans += map[r][c];
			}
		}
		System.out.println(ans);
	}

	static void zero(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		int coun = 0;
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			if (map[a[0]][a[1]] == -10000)
				continue;
			for (int d = 0; d < 4; d++) {
				if (a[0] + dr[d] >= 0 && a[0] + dr[d] < N
						&& map[a[0] + dr[d]][((a[1] + dc[d]) + M) % M] == map[a[0]][a[1]]) {
					queue.add(new int[] { a[0] + dr[d], ((a[1] + dc[d]) + M) % M });
					coun++;
				}
			}
			if (coun != 0) {
				count--;
				sum -= map[a[0]][a[1]];
				map[a[0]][a[1]] = -10000;
				change = true;
			}
		}
	}

	static void rotate() {
		int temp = 0;
		for (int i = x - 1; i < N; i += x) {
			int[] replace = new int[M];
			for (int j = 0; j < M; j++) {
				temp = j + k;
				temp %= M;
				replace[j] = map[i][temp];
			}
			map[i] = replace;
		}
	}
}
