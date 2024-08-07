package com.swea.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea7102 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input7102.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int temp;
			if (N > M) {
				temp = N;
				N = M;
				M = temp;
			}
			for (int i = N + 1; i <= M + 1; i++) {
				bw.write(i + " ");
			}
			bw.write("\n");
		}
		bw.flush();

//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}