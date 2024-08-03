package co.kr.jungol.day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class jungol1733 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("jungol/input1733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		*
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 
		0 0 0 0 1 0 2 2 1 1 1 2 0 0 0 0 0 0 0 
		0 0 0 0 0 2 1 2 2 2 2 1 0 0 0 0 0 0 0 
		0 0 0 0 0 0 2 2 0 1 2 1 0 0 0 0 0 0 0 
		0 0 0 0 0 1 2 2 2 2 1 2 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 1 2 0 1 0 2 0 0 0 0 0 0 
		0 0 0 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
		모든점에서 우상 -> 우 -> 우하 -> 하 순으로 자기 자신과 같은 값일 때
		contin값이 +1 된다 이때 contin값이 딱 5면 값 출력.
		6목을 피하기 위해 비교 진행 방향의 반대방향에 자기 자신과 같은 값이 있을 경우 넘어간다.
		출력시 5목인 경우가 없을경우 0 출력
				 */
		
		
		
		// 양옆위아래를 0으로 감싸기
		int[][] map = new int[21][21];
		for (int r = 1; r < 20; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c < 20; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 현재위치
		int nowRow = 0;
		int nowCol = 0;
		// 방향
		// 우상0 우1 우하2 하3
		int[] dr = { -1, 0, 1, 1 };
		int[] dc = { 1, 1, 1, 0 };
		// 현재방향
		int d = 0; 
		// 연속목개수
		int contin = 1;
		out: for (int r = 1; r < 20; r++) {
			for (int c = 1; c < 20; c++) {
				nowRow = r; // 현재위치 = 시작지점
				nowCol = c; // 현재위치 = 시작지점
				if (map[nowRow][nowCol] != 0) {  // 현재위치가 0이 아닐때
					for (int i = 0; i < 4; i++) { // 방향이 4개니 4번 반복
						// 연속목개수를 구하기 위한 while문
						// 현재방향으로의 다음위치와 현재위치가 같고 
						// 현재방향의 반대방향으로의 다음위치가 시작지점과 다를때 (6목이상을 피하기 위해서)
						while (map[nowRow][nowCol] == map[nowRow + dr[d]][nowCol + dc[d]] &&
								map[r][c] != map[r - dr[d]][c - dc[d]]) {
							contin++; // 연속목개수++
							nowRow += dr[d]; // 현재위치 업데이트
							nowCol += dc[d]; // 현재위치 업데이트
						}
						nowRow = r; // 다시 현재위치 = 시작지점
						nowCol = c; // 다시 현재위치 = 시작지점
						if (contin == 5) {
							break out; // 오목을 하나라도 찾으면 첫번째 for문 break
						}
						d++; // 못찾으면 방향 +1
						d = d % 4; // 인덱스 벗어날때 대비
						contin = 1; // 연속목개수 초기화
					}
				}
			}
		}
		if (contin == 5) {
			bw.write(map[nowRow][nowCol] + "\n");
			bw.write((nowRow) + " " + (nowCol));
		} else {
			bw.write(0 + "");
		}
		bw.flush();
	}
}