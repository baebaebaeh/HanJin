package com.swea.num1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num1952 {
	static int[] price;
	static int[] month;
	static int[] cost;
	static int temp;
	static int ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			price = new int[4];
			cost = new int[14];
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp * price[0] > price[1]) {
					cost[i] = price[1];
				} else {
					cost[i] = price[0] * temp;
				}
			}
			dfs(0, 0); // idx, sum
			if (ans > price[3]) ans = price[3];
			System.out.println("#" + iter + " " + ans);
		}
	}

	private static void dfs(int idx, int sum) {
		if (idx >= 12) {
			if (sum < ans) {
				ans = sum;
			}
			return;
		}
		if (cost[idx] + cost[idx + 1] + cost[idx + 2] >= price[2]) {
			dfs(idx + 3, sum + price[2]);
		}
		dfs(idx + 1, sum + cost[idx]);
	}
}