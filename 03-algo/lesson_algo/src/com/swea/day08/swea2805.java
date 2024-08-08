package com.swea.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class swea2805 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			int[] arrIn = new int[N * N];
			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					arrIn[j + i * N] = st.charAt(j)-'0';
				}
			}
			
			int temp = 0;
			int ans = 0;
			int k = 1;
			int i = 0;
			// N줄반복
			for (int iter2 = 0; iter2 < N; iter2++) {
				// Math.abs(((N - 1) / 2 - temp)) 만큼 건너띔
				for (int j = 0; j < Math.abs(((N - 1) / 2 - temp)); j++) {
					i++;
				}
				// N - Math.abs(k - N) 만큼 더하기
				for (int j = 0; j < N - Math.abs(k - N); j++) {
					ans += arrIn[i];
					i++;
				}
				// Math.abs(((N - 1) / 2 - temp)) 만큼 건너띔
				for (int j = 0; j < Math.abs(((N - 1) / 2 - temp)); j++) {
					i++;
				}
				temp++;
				k += 2;
			}
			bw.write(ans+"\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}