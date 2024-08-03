package hw;

import java.util.Arrays;

public class practice03 {
	public static void main(String[] args) {
		// 초기 배열
		int N = 5;
		int[][] arr = new int[N][N];
		
		// 무작위 수 넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}

		// 초기 배열 프린트
		for (int[] a : arr)
			System.out.println(Arrays.toString(a));

		// 정답
		int ans = 0;
		int temp = 0;
		
		// 영양분 합 구하기
		// 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				temp = 0;
				temp += arr[r][c];
				for (int i = 0; i < 4; i++) {
					if (r + dr[i] >= 0 && r + dr[i] < arr.length-1 &&
							c + dc[i] >= 0 && c + dc[i] < arr[0].length) {
						temp += arr[r+dr[i]][c+dc[i]];
					}
				}
				if (ans < temp) ans = temp;
			}
		}
		System.out.println(ans);
	}
}