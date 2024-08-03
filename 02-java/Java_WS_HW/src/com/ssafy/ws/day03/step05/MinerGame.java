package com.ssafy.ws.day03.step05;

import java.util.Scanner;

public class MinerGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] map = new int[N][N];
		// NxN광산의 암석 내구도 map
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 광부 움직임 move
		int M = sc.nextInt();
		String[] move = new String[M];
		for (int i = 0; i < M; i++) {
			move[i] = sc.next();
		}

		int zeroI = 0;
		int zeroJ = 0;
		// 내구도0 암석 위치
		// 행 : zeroI
		// 열 : zeroJ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					zeroI = i;
					zeroJ = j;
				}
			}
		}

		int nowI = zeroI;
		int nowJ = zeroJ;
		// 광부 움직이기 시작
		for (int moveI = 0; moveI < M; moveI++) {

			// 위쪽
			if (move[moveI].contains("U")) {
				// 위쪽이 막히면 넘어가라
				if (nowI == 0)
					continue;
				// 위쪽의 암석 내구도가 1 이상이면 1줄이고 현위치 변화없음
				if (map[nowI - 1][nowJ] > 0) {
					map[nowI - 1][nowJ] -= 1;
					if (map[nowI - 1][nowJ] == 0)
						nowI -= 1;
					continue;
				} else {
					// 암석 내구도 0이면 위쪽으로 이동
					nowI -= 1;
					continue;
				}
			}

			// 아래쪽
			if (move[moveI].contains("D")) {
				// 아래쪽이 막히면 넘어가라
				if (nowI == N - 1)
					continue;
				// 아래쪽의 암석 내구도가 1 이상이면 1줄이고 현위치 변화없음
				if (map[nowI + 1][nowJ] > 0) {
					map[nowI + 1][nowJ] -= 1;
					if (map[nowI + 1][nowJ] == 0)
						nowI += 1;
					continue;
				} else {
					// 암석 내구도 0이면 아래쪽으로 이동
					nowI += 1;
					continue;
				}
			}

			// 왼쪽
			if (move[moveI].contains("L")) {
				// 왼쪽이 막히면 넘어가라
				if (nowJ == 0)
					continue;
				// 왼쪽의 암석 내구도가 1 이상이면 1줄이고 현위치 변화없음
				if (map[nowI][nowJ - 1] > 0) {
					map[nowI][nowJ - 1] -= 1;
					if (map[nowI][nowJ - 1] == 0)
						nowJ -= 1;
					continue;
				} else {
					// 암석 내구도 0이면 왼쪽으로 이동
					nowJ -= 1;
					continue;
				}
			}

			// 오른쪽
			if (move[moveI].contains("R")) {
				// 오른쪽이 막히면 넘어가라
				if (nowJ == N - 1)
					continue;
				// 오른쪽의 암석 내구도가 1 이상이면 1줄이고 현위치 변화없음
				if (map[nowI][nowJ + 1] > 0) {
					map[nowI][nowJ + 1] -= 1;
					if (map[nowI][nowJ + 1] == 0)
						nowJ += 1;
					continue;
				} else {
					// 암석 내구도 0이면 오른쪽으로 이동
					nowJ += 1;
					continue;
				}
			}

			int[] tempI = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
			int[] tempJ = new int[] { 1, 1, 1, 0, -1, -1, -1, 0 };
			// 다이너마이트
			if (move[moveI].contains("X")) {
				// 범위 넘어가기 방지
				// 현재위치 주변 8칸 0으로 변경
				for (int i = 0; i < 8; i++) {
					if (nowI + tempI[i] >= 0 && nowI + tempI[i] < N && nowJ + tempJ[i] >= 0 && nowJ + tempJ[i] < N) {
						map[nowI + tempI[i]][nowJ + tempJ[i]] = 0;
					}
				}
			}
		}

		// 0개수 확인
		// 처음 자리 빼줌
		int zeroCnt = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}

		System.out.println("광부 위치 : (" + nowI + "," + nowJ + ")");
		System.out.println("부순 암석 개수 : " + zeroCnt);
	}
}
