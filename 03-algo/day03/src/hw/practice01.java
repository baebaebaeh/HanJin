package hw;

import java.util.Arrays;

public class practice01 {
	public static void main(String[] args) {
		// 정답 생성
		int sum = 0;
		
		// 초기 배열 생성
		int[][] arr = new int[2][1];
		
		// 무작위 수 넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int) (Math.random()*10);
			}
		}
		
		// 초기 배열 프린트
		for (int[] a : arr)
			System.out.println(Arrays.toString(a));
		
		// 절댓값 합 구하기
		//          상0 하1 좌2 우3
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		// 모든요소를
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				for (int k = 0; k < 4; k++) {
					if (0 <= r + dr[k] && r + dr[k] < arr.length &&
							0 <= c + dc[k] && c + dc[k] <arr[0].length) {
						sum += Math.abs(arr[r+dr[k]][c+dc[k]] - arr[r][c]);
					}
				}
			}
		}
		System.out.println(sum);
	}
}