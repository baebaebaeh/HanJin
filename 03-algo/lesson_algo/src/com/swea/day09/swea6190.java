package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea6190 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input6190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int ans = -1;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N - 1; i++) {
				out : for (int j = i + 1; j < N; j++) {
					int numInt = arr[i] * arr[j];
					String numStr = numInt + "";
					for (int k = 0; k < numStr.length() - 1; k++) {
						if (numStr.charAt(k) > numStr.charAt(k + 1)) continue out;
					}
					if (ans < numInt) ans = numInt;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
		System.out.println(Math.PI);
	}
}