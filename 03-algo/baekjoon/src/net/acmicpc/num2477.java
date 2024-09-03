package net.acmicpc;

import java.util.Scanner;

public class num2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] direction = new int[12];
		int[] length = new int[12];
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < 12; i++) {
			if (i % 2 == 0) {
				direction[temp1] = sc.nextInt();
				temp1++;
			} else {
				length[temp2] = sc.nextInt();
				temp2++;
			}
		}
		
		// 오류 해결하려고 무식하게 배열 늘려놓음 추후 수정필요
		for (int i = 0; i < 6; i++) {
			direction[i+6] =  direction[i];
			length[i+6] =  length[i];
		}
		
		
		
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			if (direction[i] == direction[i+2]) { // 같은방향이 2칸 간격으로 나왔을때
				temp1 = 0; // 같은 방향이 2칸 간격으로 나왔을때의 첫번재 인덱스
				temp2 = 0; // 같은 방향이 2칸 간격으로 나왔을때의 두번재 인덱스
				if (i-1 < 0)
					temp1 += 6; // 인덱스 넘어가기 방지
				temp1 += i-1; // 첫번째 인덱스의 왼쪽 (-1)
				if (i+3 >= 6)
					temp2 -= 6;
				temp2 += i+3; // 두번째 인덱스의 오른쪽 이면 첫번째 인덱스의 오른쪽으로 3번째 (+3)
				sum = length[i] * length[temp1] + length[i+2] * length[temp2];
			}
		}
		System.out.println(sum*N); // 참외 곱해주기
		int [][] line = new int [6][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <2; j++) {
				line[i][j] = sc.nextInt();
			}
		}
		
		int temp = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <2; j++) {
				
			}
		}
	}
}
