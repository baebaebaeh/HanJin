package com.swea.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1966 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 삽입정렬
			for (int i = 1; i < arr.length; i++) {
				int data = arr[i];
				int j = 0;
				for (j = i - 1; j >= 0; j--) {
					if (data < arr[j]) {
						arr[j + 1] = arr[j];
						continue;
					}
					break;
				}
				arr[j + 1] = data;
			}
			for (int a : arr) {
				bw.write(a + " ");
			}
			bw.write("\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}