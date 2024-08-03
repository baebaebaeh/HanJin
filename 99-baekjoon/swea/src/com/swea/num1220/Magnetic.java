package com.swea.num1220;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Magnetic {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1220.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();  // 의미없는 100의 값 처리
			
			int[][] map = new int[100][100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// 열단위로 읽으면서 교착 상태 찾기
			int ans = 0;
			for (int c = 0; c < 100; c++) {
				int prev = 0;
				for (int r = 0; r < 100; r++) {
					if (map[r][c] == 0) continue;
					if (map[r][c] == 2 && prev == 1) ans++;
					
					prev = map[r][c];
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		//sdsdsdsd
	}
}