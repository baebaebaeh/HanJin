package com.swea.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea2817 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] arr;
	static int N, K;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input2817.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			부분집합();
		}
		bw.flush();
	}
	private static void 부분집합() throws IOException {
		int ans = 0;
		for (int i = 0; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
			if (sum == K) {
				ans++;
			}
		}
		bw.write(ans + "\n");
	}
}