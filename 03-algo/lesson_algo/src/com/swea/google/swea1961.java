package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1961 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// 모든 테스트 케이스
		for (int iter = 1; iter <= T; iter++) {
			// map 생성
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 쓰기
			bw.write("#" + iter + "\n");
			for (int i = 0; i < N; i++) {
				//90도
				for (int j = 0; j < N; j++) {
					bw.write(map[N - 1 - j][i] + "");
				}
				bw.write(" ");
				//180도
				for (int j = 0; j < N; j++) {
					bw.write(map[N - 1 - i][N - 1 - j] + "");
				}
				bw.write(" ");
				//270도
				for (int j = 0; j < N; j++) {
					bw.write(map[j][N - 1 - i] + "");
				}
				bw.write("\n");
			}
		}
//		bw.write("#" + iter + " " + ans + "\n");
		bw.flush();
	}
}