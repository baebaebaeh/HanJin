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
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17070_dp {
	static boolean[][] wall;
	static int[][][] count;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		wall = new boolean[N][N];
		count = new int[N][N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					wall[r][c] = true;
				}
			}
		}
		for (boolean[] a : wall) {
			System.out.println(Arrays.toString(a));
		}
		count[0][1][0]++;
		for (int c = 1; c < N; c++) {
			if (!wall[0][c]) {
				count[0][c][0] += count[0][c - 1][0];
			}
		}
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if (!wall[r][c]) {
					count[r][c][0] += count[r][c - 1][0];
					count[r][c][0] += count[r][c - 1][1];
					count[r][c][2] += count[r - 1][c][1];
					count[r][c][2] += count[r - 1][c][2];
					if (!wall[r - 1][c] && !wall[r][c - 1]) {
						count[r][c][1] += count[r - 1][c - 1][0];
						count[r][c][1] += count[r - 1][c - 1][1];
						count[r][c][1] += count[r - 1][c - 1][2];
					}
				}
			}
		}
		int sum = 0;
		sum += count[N - 1][N - 1][0];
		sum += count[N - 1][N - 1][1];
		sum += count[N - 1][N - 1][2];
		System.out.println(sum);
	}
}
