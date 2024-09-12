package net.acmicpc.num12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num12865 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N];
		int[] cost = new int[N];
		int[] dp = new int[K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= 0; j--) {
				if (j - weight[i] < 0) {
					continue;
				}
				if (dp[j] < cost[i] + dp[j - weight[i]]) {
					dp[j] = cost[i] + dp[j - weight[i]];
				}
			}
		}
		System.out.println(dp[K]);
	}
}