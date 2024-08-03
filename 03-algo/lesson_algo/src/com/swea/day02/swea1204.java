package com.swea.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1204 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int iter = 0; iter < T; iter++) {
			int[] grade = new int[101];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				grade[Integer.parseInt(st2.nextToken())]++;
			}
			int ans = 0;
			int prev = grade[0];
			for (int i = 0; i < 100; i++) {
				if (prev <= grade[i+1]) {
					ans = 0;
					prev = grade[i+1];
					continue;
				}
				ans++;
			}
			bw.write("#" + (iter + 1) + " " + (100-ans) + "\n");
			bw.flush();
		}
	}
}