package hw;

import java.util.Arrays;

public class page11 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5]; // 초기 배열
		
		
		for (int i = 0; i < arr.length; i++) { // 초기 배열에 무작위 수 부여
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}
		
		// 초기 배열 프린트
		System.out.println("초기 배열");
		for (int[] a : arr) 
			System.out.println(Arrays.toString(a));
		
		// 새로운 배열 생성
		int[][] newArr = new int[arr.length][arr[0].length]; 

		// 회전 시작
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				// 행과 열을 바꾼 후(전치) 중앙을 기준으로 y축 대칭 -> 시계방향
				// 행과 열을 바꾼 후(전치) 중앙을 기준으로 x축 대칭 -> 반시계방향
				newArr[j][arr.length - 1 - i] = arr[i][j]; 
			}
		}
		// 바뀐 배열 프린트
		System.out.println("바뀐 배열");
		for (int[] a : newArr)
			System.out.println(Arrays.toString(a));
	}
}
