package com.swea.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class swea4012 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][] map;
	static int[] data;
	static int N;
	static int ans = 9999999;
	static int[] arr = new int[2];
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
			int temp = 1;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = temp; j < N; j++) {
					data[idx] = map[i][j] + map[j][i];
					idx++;
				}
				temp++;
			}
			System.out.println(Arrays.toString(data));
			minSum(0, 0);
			System.out.println(ans);
			ans = 9999999;
			
		}
	}
	private static void minSum(int start, int startIdx) {
		if (startIdx == 2) {
			int sum = Math.abs((arr[0] - arr[1])); 
			if (sum < ans) ans = sum;
			return;
		}
		for (int i = start; i <= data.length - 2 + startIdx; i++) {
			arr[startIdx] = data[i];
			minSum(i + 1, startIdx + 1);
		}
	}
}