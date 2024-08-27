package com.swea.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class swea4012_ {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][] map;
	static int[] data;
	static int N;
	static int ans = 9999999;
	static int[] arr = new int[2];
	static List<int[]> list = new ArrayList<>();
	static int[][] arr2 = new int[2][];
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input4012.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			data = new int[N * N / 2 - (N / 2)];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map[i][j] + map[j][i];
					map[j][i] = map[i][j];
				}
			}
			minSum(0, 0);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(Arrays.toString(list.get(i))); 
			}
			s(0,0);
			System.out.println(ans);
		}
	}
	private static void minSum(int start, int startIdx) {
		if (startIdx == 2) {
			list.add(arr);
			return;
		}
		for (int i = start; i <= N - 2 + startIdx; i++) {
			arr[startIdx] = i;
			minSum(i + 1, startIdx + 1);
		}
	}
	private static void s(int start, int startIdx) {
		if (startIdx == 2) {
			int tmp = 0;
			tmp = Math.abs((map[arr2[0][0]][arr2[0][1]] - map[arr2[1][0]][arr2[1][1]]));
			if (ans > tmp) ans = tmp;
			return;
		}
		for (int i = start; i <= list.size() - 2 + startIdx; i++) {
			arr2[startIdx] = list.get(i);
			minSum(i + 1, startIdx + 1);
		}
	}
}