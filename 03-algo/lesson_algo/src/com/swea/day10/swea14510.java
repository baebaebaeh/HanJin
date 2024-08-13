package com.swea.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea14510 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > max)
					max = arr[i];
			}
			int one = 0;
			int two = 0;
			for (int i = 0; i < N; i++) {
				int grow = max - arr[i];
				if (grow % 2 == 1) one++;
				two += grow / 2;
			}
			
			if (two > one) {
				while (Math.abs(one - two) > 1) {
					one += 2;
					two--;
				}
			}

			int ans = 0;
			if (one > two) {
				ans = one * 2 - 1;
			}
			if (two >= one) {
				ans = two * 2;
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}