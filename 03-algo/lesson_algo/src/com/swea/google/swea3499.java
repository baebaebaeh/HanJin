package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea3499 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[(N + 1) / 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < (N + 1) / 2; i++) {
				arr[i] = st.nextToken();
			}
			for (int i = 0; i < N / 2; i++) {
				bw.write(arr[i] + " ");
				bw.write(st.nextToken() + " ");
			}
			if (N % 2 == 1) {
				bw.write(arr[arr.length - 1]);
			}
			bw.write("\n");
		}
		bw.flush();

//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}