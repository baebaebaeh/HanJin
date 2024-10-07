package net.acmicpc.num11066;

import java.io.*;
import java.util.*;

public class num11066 {
	static int[][] dp;
	static int[] arr;
	static int tmp, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input11066.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			int K = Integer.parseInt(br.readLine());
			dp = new int[K + 1][K + 1];
			arr = new int[K + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= K; j++) {
				int L = Integer.parseInt(st.nextToken());
				arr[j] = arr[j - 1] + L;
			}
			for (int count = 1; count <= K - 1; count++) {
				for (int i = 1; i <= K - count; i++) {
					ans = Integer.MAX_VALUE;
					for (int j = 1; j <= count; j++) {
						tmp = dp[i][i - 1 + j] + dp[i + j][i + count] - arr[i - 1] + arr[i + count];
						if (ans > tmp) {
							ans = tmp;
						}
					}
					dp[i][i + count] = ans;
				}
			}
			bw.write(dp[1][K] + "\n");
		}
		bw.flush();
	}
}