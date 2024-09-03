package net.acmicpc;

import java.util.Scanner;

public class num2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ans = new char[4];
		for (int iter1 = 0; iter1 < 4; iter1++) {
			int[][] map = new int[2][4];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			if (map[1][2] <= map[0][0]) { //왼
				if ((map[1][2] == map[0][0]) && !(map[0][1] > map[1][3]) && !(map[1][1] > map[0][3])) {
					if ((map[1][3] == map[0][1]) 
							|| (map[1][1] == map[0][3])) {
						ans[iter1] = 99;
						continue;
					}
					ans[iter1] = 98;
					continue;
				}
				ans[iter1] = 100;
				continue;
			}
			if (map[1][0] >= map[0][2]) { //오
				if ((map[0][2] == map[1][0]) && !(map[0][1] > map[1][3]) && !(map[1][1] > map[0][3])) {
					if ((map[0][3] == map[1][1]) 
							|| (map[0][1] == map[1][3])) {
						ans[iter1] = 99;
						continue;
					}
					ans[iter1] = 98;
					continue;
				}
				ans[iter1] = 100;
				continue;
			}
			if (map[1][3] <= map[0][1]) { //아래
				if ((map[1][3] == map[0][1]) && !(map[0][0] > map[1][2]) && !(map[1][0] > map[0][2])) {
					ans[iter1] = 98;
					continue;
				}
				ans[iter1] = 100;
				continue;
			}
			if (map[1][1] >= map[0][3]) { //위
				if ((map[1][1] == map[0][3]) && !(map[0][0] > map[1][2]) && !(map[1][0] > map[0][2])) {
					ans[iter1] = 98;
					continue;
				}
				ans[iter1] = 100;
				continue;
			}
			ans[iter1] = 97;
		}
		for (char a : ans) {
			System.out.println(a);

		}
	}
}
