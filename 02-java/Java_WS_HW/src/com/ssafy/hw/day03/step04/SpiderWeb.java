package com.ssafy.hw.day03.step04;

import java.util.Scanner;

public class SpiderWeb {

	public static void main(String[] args) {
		// 거미줄 치면 +1   0번인덱스는 최대 갯수 1번과 2번은 시작 위치 i j
		int [] tempWeb = new int [3];
		int [] maxWeb = new int [3];

		// scan
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// map 생성
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 모든 N x N 요소 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 현재위치가 0인지 확인
				if (map[i][j] == 0) {
					
					//시작 위치 따기
					tempWeb[1] = i;
					tempWeb[2] = j;

					// tempWeb 초기화
					tempWeb [0] = 0;

					// 각 요소의 오른쪽 탐색
					int tempRepeat = 0; // 거미줄 한번 못치면 +1 2되면 break
					for (int d = 1; j + d < N; d++) {
						if (tempRepeat != 2) {

							if (map[i][j + d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 왼쪽 탐색
					tempRepeat = 0;
					for (int d = 1; j - d >= 0; d++) {
						if (tempRepeat != 2) {

							if (map[i][j - d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 아래쪽 탐색
					tempRepeat = 0;
					for (int d = 1; i + d < N; d++) {
						if (tempRepeat != 2) {

							if (map[i + d][j] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 위쪽 탐색
					tempRepeat = 0;
					for (int d = 1; i - d >= 0; d++) {
						if (tempRepeat != 2) {

							if (map[i - d][j] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 오른쪽 위 탐색
					tempRepeat = 0;
					for (int d = 1; i - d >= 0 && j + d < N; d++) {
						if (tempRepeat != 2) {

							if (map[i - d][j + d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 오른쪽 아래 탐색
					tempRepeat = 0;
					for (int d = 1; i + d < N && j + d < N; d++) {
						if (tempRepeat != 2) {

							if (map[i + d][j + d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 왼쪽 위 탐색
					tempRepeat = 0;
					for (int d = 1; i - d >= 0 && j - d >= 0; d++) {
						if (tempRepeat != 2) {

							if (map[i - d][j - d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}

					// 각 요소의 왼쪽 아래 탐색
					tempRepeat = 0;
					for (int d = 1; i + d < N && j - d >= 0; d++) {
						if (tempRepeat != 2) {

							if (map[i + d][j - d] == 0) {
								tempWeb [0] += 1;
								tempRepeat = 0;
							} else {
								tempRepeat += 1;
							}

						}
					}
					
					if (maxWeb[0] < tempWeb[0]) {
						maxWeb[0] = tempWeb[0];
						maxWeb[1] = tempWeb[1];
						maxWeb[2] = tempWeb[2];
//						maxWeb = tempWeb; 이렇게 쓰면 maxWeb이 tempWeb의 주소값을 
//						복사해서 tempWeb이 바뀔 때 마다 maxWeb도 같이 바뀐다.
					}
					
				}
			}
		}
		
		//시작 위치 더하기
		maxWeb[0] = maxWeb[0]+1;
		
		//프린트
		System.out.println(maxWeb[0]);
		System.out.println(maxWeb[1] + "," + maxWeb[2]);
	}
}
