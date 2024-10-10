package net.acmicpc.num7579;

import java.io.*;
import java.util.*;

public class num7579 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input7579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memory = new int[N];
		int[] cost = new int[N];
		int costSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			costSum += cost[i];
		}

		int[] dp = new int[costSum + 1];
		for (int i = 0; i < N; i++) {
			for (int j = costSum; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
			}
		}
		int minMemory = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = costSum; i >= 0; i--) {
			if (minMemory >= dp[i] && M <= dp[i]) {
				minMemory = dp[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
}