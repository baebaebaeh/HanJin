package com.swea.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1860 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1860.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		out : for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] count = new int[11112];
			for (int i = 0; i < N; i++) {
				count[Integer.parseInt(st.nextToken())]--;
			}
			if (count[0] < 0) {
				bw.write("Impossible \n");
				continue out;
			}
			for (int i = M; i < 11112; i += M) {
				count[i] += K;
			}
			for (int i = 1; i < 11112; i++) {
				count[i] += count[i-1];
				if (count[i] < 0) {
					bw.write("Impossible \n");
					continue out;
				}
			}
			bw.write("Possible \n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}