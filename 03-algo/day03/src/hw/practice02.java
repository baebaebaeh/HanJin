package hw;

import java.util.Arrays;

public class practice02 {
	public static void main(String[] args) {
		// 초기 배열 설정
		int[][] arr = new int[5][5];

		// 무작위 수 넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}
		
		// 초기 배열 프린트
		for (int[] a : arr)
			System.out.println(Arrays.toString(a));
	
		// 방향 dr dc 만들어주기
		// 우0 하1 좌2 상3
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		// 초기(현재)방향
		int d = 0;
		
		// 초기(현재)위치
		int[] p = { 0, 0 };
		
		// 프린트 한 횟수
		int num = 0;
		
		int[] A = new int[arr.length * arr[0].length];
		int idx = 0;
		while (num < arr.length * arr[0].length) {
			System.out.print(arr[p[0]][p[1]] + " ");
			// 다음 방향으로의 인덱스가 존재하고
			// 다음 방향의 값이 -1 이 아닐때
			if (p[0] + dr[d] >= 0 && p[0] + dr[d] < arr.length && 
					p[1] + dc[d] >= 0 && p[1] + dc[d] < arr[0].length
					&& arr[p[0] + dr[d]][p[1] + dc[d]] != -1) {
				// 현재위치를 -1로 바꾸고
				arr[p[0]][p[1]] = -1;
				// 현재위치를 다음 인덱스로 바꾼다
				p[0] = p[0] + dr[d];
				p[1] = p[1] + dc[d];
				num += 1; // 돈 횟수 +1
				continue;
			}
			// 아닐 경우 방향을 바꾸고
			d += 1;
			d = d % 4; // dr의 배열은 4개니 넘어가면 처음으로 돌아와라
			// 현재위치를 다음인덱스로 바꾼다.
			p[0] = p[0] + dr[d];
			p[1] = p[1] + dc[d];
			num += 1; // 돈 횟수 +1
			
		}
	}
}