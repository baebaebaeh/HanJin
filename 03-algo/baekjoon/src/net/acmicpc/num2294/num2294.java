package net.acmicpc.num2294;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class num2294 {
	static int[] dp;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input2294.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		dp = new int[k + 1];
		for (int i = 1; i < k + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i - cost[j] >= 0 && dp[i - cost[j]] != Integer.MAX_VALUE) {
					int now = dp[i - cost[j]] + 1;
					if (dp[i] == 0) {
						dp[i] = now;
						continue;
					}
					if (dp[i] > now) {
						dp[i] = now;
					}
				}
			}
		}
		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(dp[k]);
		}
		
	}
}