package com.swea.day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea9490 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input9490.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스 반복
		for (int iter = 1; iter <= T; iter++) {
			// N M map 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			// map 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 모든 요소 확인 시작
			// 상0 하1 좌2 우3
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			// 정답 생성
			int max = 0;
			// 모든 좌표에 대해서
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int sum = 0;
					// 상하좌우 4번 반복하고
					for (int d = 0; d < 4; d++) {
						// 현재 값만큼 반복
						for (int i = 1; i <= map[r][c]; i++) {
							// 인덱스 벗어나지 않는 경우에 대해서만
							if (r + dr[d] * i >= 0 && r + dr[d] * i < N && 
									c + dc[d] * i >= 0 && c + dc[d] * i < M) {
								// 값을 더해준다
								sum += map[r + dr[d] * i][c + dc[d] * i];
							}
						}
					}
					// 현재값도 더해준다.
					sum += map[r][c];
					// max값 보다 크면 업데이트
					if (max < sum) max = sum;
				}
			}
			// 프린트
			bw.write("#" + iter + " " + max + "\n");
		}
		bw.flush();
	}
}