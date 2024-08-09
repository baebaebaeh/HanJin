package com.swea.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1859 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1859.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			int temp = arr[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (temp - arr[i] > 0) {
					sum += temp - arr[i];
					continue;
				}
				temp = arr[i];
			}
			bw.write("#" + iter + " " + sum + "\n");
		}
		bw.flush();
	}
}