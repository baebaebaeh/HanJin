package com.swea.num2382;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num2382 {
	static int[][][] map;
	static int[][] mi;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][N][2];
			mi = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				mi[i][0] = r;
				mi[i][1] = c;
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if (d == 1) {
					d = 0	;
				} else if (d == 2) {
					d = 2;
				} else if (d == 3) {
					d = 3;
				} else if (d == 4) {
					d = 1;
				}
				map[r][c][0] = num;
				map[r][c][1] = d;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < K; j++) {
					int r = mi[j][0];
					int c = mi[j][1];
					int nr = r + dr[map[r][c][1]];
					int nc = c + dr[map[r][c][1]];
					if (map[nr][nc][0] < map[r][c][0]) {
						int[] tmp = map[r][c];
						map[r][c] = map[nr][nc];
						map[nr][nc] = tmp;						
					}
					if (map[nr][nc][0] > map[r][c][0]) {
						map[nr][nc][0] += map[r][c][0];
					}
				}
			}
		}
	}
}