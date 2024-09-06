package com.swea.num1486;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num1486 {
	static int[] people;
	static int[] sel;
	static int N, B, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			people = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			subSet(0, 0);
			System.out.println("#" + iter + " " + ans);
		}
	}
	private static void subSet(int start, int startIdx) {
		for (int i = 0; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (((1 << j) & i) != 0) {
					sum += people[j];
				}
			}
			if (sum >= B && sum - B < ans) ans = sum - B;
		}
	}
}