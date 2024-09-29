package com.swea.num4012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num4012 {
	static int[][] map;
	static int[] sel1, sel2, sel3;
	static int[] data;
	static int N, S, ans, sum1, sum2;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC =  Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N =  Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			S = N / 2;
			sel1 = new int[S];
			sel2 = new int[S];
			sel3 = new int[2];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[r][c] = tmp;
				}
			}
			comb(0, 0);
			bw.write("#" + testCase + " " + ans + "\n");
		}
		bw.flush();
	}
	static void comb(int start, int startIdx) {
		if (startIdx == S) {
			sum1 = 0;
			sum2 = 0;
			int tmp1 = 0;
			int tmp2 = 0;
			for (int i = 0; i < N; i++) {
				if (tmp1 < S) {
					if (sel1[tmp1] == i) {
						tmp1++;
						continue;
					}
				}
				sel2[tmp2++] = i;
			}
			comb2(0, 0);
			comb3(0, 0);
			if (ans > Math.abs(sum1 - sum2)) {
				ans = Math.abs(sum1 - sum2);
			}
			return;
		}
		for (int i = start; i <= N - S + startIdx; i++) {
			sel1[startIdx] = i;
			comb(i + 1, startIdx + 1);
		}
	}
	private static void comb2(int start, int startIdx) {
		if (startIdx == 2) {
			sum1 += map[sel3[0]][sel3[1]] +map[sel3[1]][sel3[0]];
			return;
		}
		for (int i = start; i <= S - 2 + startIdx; i++) {
			sel3[startIdx] = sel1[i];
			comb2(i + 1, startIdx + 1);
		}
	}
	private static void comb3(int start, int startIdx) {
		if (startIdx == 2) {
			sum2 += map[sel3[0]][sel3[1]] +map[sel3[1]][sel3[0]];
			return;
		}
		for (int i = start; i <= S - 2 + startIdx; i++) {
			sel3[startIdx] = sel2[i];
			comb3(i + 1, startIdx + 1);
		}
	}
}