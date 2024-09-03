package net.acmicpc;

import java.util.Scanner;

public class num2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] x = new int [N]; // 검은 색종이 x값
		int[] y = new int [N]; // 검은 색종이 y값
		int[][] map = new int[102][102]; // map을 양옆에 한칸씩 더 크게 만듦
		for (int i = 0; i < N; i++) { // 스캔
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		// 위 아래 양 옆 한칸씩 띄워서 검은 색종이 집어 넣기
		for (int iter = 0; iter < N; iter++) { 
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					map[i + y[iter]][j + x[iter]] += 1;
				}
			}
		}
		
		// map[i][j]와 map[i][j+1] 비교하면서 0에서    0이아닐때 +1
		//								  0이아닐때에서 0으로 +1
		int ans = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if ((map[i][j] == 0) && (!(map[i][j+1] == 0))) {
					// map 크기를 위아래양옆 2칸씩 안늘려주면 이때 고장남
					ans += 1;
				}
				if ((!(map[i][j] == 0)) && (map[i][j+1] == 0)) {
					ans += 1;
				}
			}
		}
		
		// map[i][j]와 map[i+1][j] 비교하면서 0에서    0이아닐때 +1
		//								  0이아닐때에서 0으로 +1
		for (int j = 0; j < 101; j++) {
			for (int i = 0; i < 101; i++) {
				if ((map[i+1][j] == 0) && (!(map[i][j] == 0))) {
					ans += 1;
				}
				if ((!(map[i+1][j] == 0)) && (map[i][j] == 0)) {
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
