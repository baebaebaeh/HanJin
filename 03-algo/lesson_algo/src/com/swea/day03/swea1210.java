package com.swea.day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1210 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("data/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 0; iter < 10; iter++) { // 테스트케이스 10개

			// map 생성
			int[][] map = new int[102][102]; // 양옆위아래를 0으로 감싸기
			// 현재위치
			int nowRow = 0;
			int nowCol = 0;

			br.readLine(); // 한줄 건너 띄기

			for (int r = 1; r < 101; r++) { // map에 집어넣기
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 1; c < 101; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 2) { // 2인 위치 찾기
						nowRow = r;
						nowCol = c;
					}
				}
			}
			// 여기서부터 시작
			// 방향
			// 좌0 우1 상2
			int[] dr = { 0, 0, -1 };
			int[] dc = { -1, 1, 0 };
			int d = 0;

			// 현재 위치의 row가 -1 될때까지 올라감
			while (map[nowRow + dr[2]][nowCol + dc[2]] != 0) { // 현재위치의 위쪽이 0이면 멈춰라
//				nowRow += dr[2]; // 맨 아랫줄이 이어져 있으면 오류 날것 같아서 수정함
//				nowCol += dc[2];
				if (map[nowRow + dr[0]][nowCol + dc[0]] == 1) { // 현재위치의 왼쪽이 1이면
					while (map[nowRow + dr[0]][nowCol + dc[0]] != 0) { // 왼쪽이 0 나오기전까지 움직이고
						nowRow += dr[0];
						nowCol += dc[0];
					}
				} else { // 현재위치의 오른쪽이 1이면
					while (map[nowRow + dr[1]][nowCol + dc[1]] != 0) { // 오른쪽이 0 나오기전까지 움직이고
						nowRow += dr[1];
						nowCol += dc[1];
					}
				}
				nowRow += dr[2]; // 좌우측 둘다 1이 아니면 현재위치에서 한칸 위로 올라가라
				nowCol += dc[2];
			}

			// 위아래를 0으로 감싸서 인덱스 -1씩 해줘야함
			nowRow -= 1;
			nowCol -= 1;
			bw.write("#" + (iter + 1) + " " + Integer.toString(nowCol) + "\n");
		}
		bw.flush();
	}
}