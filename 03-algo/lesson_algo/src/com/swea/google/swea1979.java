package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1979 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// map생성 및 스캔
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 들어갈 수 있는 단어길이를 인덱스로 가지는 배열
			int[] arr = new int[N + 1];
			
			// 방향
			// 우0 하1
			int[] dr = {0, 1};
			int[] dc = {1, 0};
			
			// 일단 오른쪽만
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int wordLen = 1;
					while (r + dr[0] < N && c + dc[0] < N && map[r][c] == 1 &&
							map[r + dr[0]][c + dc[0]] == 1) {
						c += dc[0];
						wordLen += 1;
					}
					arr[wordLen] += 1;
				}
			}
			// 아래쪽
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					int wordLen = 1;
					while (r + dr[1] < N && c + dc[1] < N && map[r][c] == 1 && 
							map[r + dr[1]][c + dc[1]] == 1) {
						r += dr[1];
						wordLen += 1;
					}
					arr[wordLen] += 1;
				}
			}
			bw.write(arr[K] + "\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}