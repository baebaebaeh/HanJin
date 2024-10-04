package net.acmicpc.num10942;

import java.io.*;
import java.util.*;

public class num10942 {
	static int[][] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input10942.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i - 1])
				dp[i - 1][i] = 1;
		}
		int size = 2;
		while (size <= N - 1) {
			for (int i = 0; i < N - size; i++) {
				int r = i;
				int c = i + size;
				if (arr[r] == arr[c]) {
					dp[r][c] = dp[r + 1][c - 1];					
				}
			}
			size++;
		}
		int M = Integer.parseInt(br.readLine());	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bw.write(dp[r - 1][c - 1] + "\n");
		}
		bw.flush();
	}
}