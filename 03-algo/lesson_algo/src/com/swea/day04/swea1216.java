package com.swea.day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//회문2
class swea1216 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 10가지 테스트 케이스
		for (int iter = 1; iter < 11; iter++) {
			br.readLine(); // 한줄 버리고
			char[][] map = new char[100][]; // 빈 char배열을 가진 2차원 배열 생성
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i] = st.nextToken().toCharArray(); // 100 * 100 char 배열 생성됨
			}

			int maxGap = 0; // 최대길이
			// 가로문자 비교
			for (int i = 0; i < 100; i++) {
				char prev = 'X'; // ABC가 아닌 아무 char넣음
				for (int j = 0; j < 100; j++) {
					int gap = 0; // 어떤 값의 왼쪽 오른쪽 비교할때 사용하는 값
					
					// 한칸을 기준으로 양옆의 값이 존재하고 그 값이 같을때
					while (j - gap >= 0 && j + gap < 100 && map[i][j - gap] == map[i][j + gap]) {
						gap += 1;
					}
					// 회문 길이
					gap = (gap - 1) * 2 + 1; // while에서 gap이 한번 더 더해져서 -1, gap은 양옆으로 길어지니까 * 2, 기준1칸 +1
					if (maxGap < gap)
						maxGap = gap; // maxGap 바꿔주기
					gap = 0; // 다시 gap 0으로
					
					// 이전 char가 현재 char랑 같을 때 그 두개의 값을 기준으로 양옆의 값이 존재하고 그 값이 같을때
					while (prev == map[i][j] && j - 1 - gap >= 0 && j + gap < 100
							&& map[i][j - 1 - gap] == map[i][j + gap]) {
						gap += 1;
					}
					prev = map[i][j];
					gap = (gap - 1) * 2 + 2; // while에서 gap이 한번 더 더해져서 -1, gap은 양옆으로 길어지니까 * 2, 기준2칸 +2
					if (maxGap < gap)
						maxGap = gap;
				}
			}
			// 세로문자 비교
			for (int j = 0; j < 100; j++) {
				char prev = 'X';
				for (int i = 0; i < 100; i++) {
					int gap = 0;
					while (i - gap >= 0 && i + gap < 100 && map[i - gap][j] == map[i + gap][j]) {
						gap += 1;
					}
					gap = (gap - 1) * 2 + 1;
					if (maxGap < gap)
						maxGap = gap;
					gap = 0;
					while (prev == map[i][j] && i - 1 - gap >= 0 && i + gap < 100
							&& map[i - 1 - gap][j] == map[i + gap][j]) {
						gap += 1;
					}
					prev = map[i][j];
					gap = (gap - 1) * 2 + 2;
					if (maxGap < gap)
						maxGap = gap;
				}
			}
			bw.write(maxGap + "\n");
		}
		bw.flush();
	}
}