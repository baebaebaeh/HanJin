package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class swea1974 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		out : for (int iter = 1; iter <= 10 ; iter++) {
			bw.write("#" + iter + " ");
			// map 생성
			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 행의 개수와 열의 개수 판단
			for (int i = 0; i < 9; i++) {
				Set<Integer> set1 = new HashSet<>();
				Set<Integer> set2 = new HashSet<>();
				for (int j = 0; j < 9; j++) {
					// set에 넣으면 겹치는 숫자가 사라짐
					set1.add(map[i][j]);
					set2.add(map[j][i]);
				}
				// 겹치는 숫자가 있었으면 0출력후 다음 테스트케이스로
				if (set1.size() != 9 || set2.size() != 9) {
					bw.write("0\n");
					continue out;
				}
			}
			// 네모안의 개수 판단
			// row인덱스 시작 위치
			for (int i = 0; i < 9; i += 3) {
				// col인덱스 시작 위치
				for (int j = 0; j < 9; j += 3) {
					Set<Integer> set1 = new HashSet<>();
					// 시작위치로 부터 3칸까지
					for (int i1 = i; i1 < i + 3; i1++) {
						// 시작위치로 부터 3칸까지
						for (int j1 = j; j1 < j + 3; j1++) {
							// set에 넣으면 겹치는 숫자가 사라짐
							set1.add(map[i1][j1]);
						}
					}
					// 겹치는 숫자가 있었으면 0출력후 다음 테스트케이스로
					if (set1.size() != 9) {
						bw.write("0\n");
						continue out;
					}
				}
			}
			// 위를 무사히 통과했으면 1출력
			bw.write("1\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}