package com.swea.num1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num1952_DP {
	static int[] price;
	static int[] plan;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		price = new int[4];
		plan = new int[13];
		dp = new int[13];
		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= 12; i++) {
				dp[i] = Integer.MAX_VALUE;
			}
			for (int i = 1; i <= 12; i++) {
				int day = plan[i] * price[0] + dp[i - 1];
				dp(day, i);
				int month = price[1] + dp[i - 1];
				dp(month, i);
				if (i >= 3) {
					int month3 = price[2] + dp[i - 3];
					dp(month3, i);
				}
				if (i >= 12) {
					int year = price[3] + dp[i - 12];
					dp(year, i);
				}
			}
			bw.write(("#" + testCase + " " + dp[12] + "\n"));
		}
		bw.flush();
	}

	static void dp(int cost, int i) {
		if (cost < dp[i]) {
			dp[i] = cost;
		}
	}
}