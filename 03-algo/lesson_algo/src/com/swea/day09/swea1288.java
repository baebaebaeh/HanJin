package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class swea1288 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1288.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int[] arr = new int[10];
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			int i;
			for (i = 1; !isTen(arr); i++){ // 10개가 안모였으면
				int n = N * i;
				while(n != 0) {
					arr[n % 10]++;
					n /= 10;
				}
			}
			bw.write(((i-1) * N) + "\n");
		}
		bw.flush();
	}
	static boolean isTen(int[] arr) {
		for (int i = 0; i < 10; i++) {
			if (arr[i] == 0) return false;
		}
		return true;
	}
}