package net.acmicpc;

import java.util.Scanner;

public class num1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		// 원탁
		int[] friends = new int [N];
		for (int i = 0; i < N; i++)
			friends[i] = i+1;
		
		// 공 받은 횟수
		int[] ballCnt = new int [N];
		
		// 공 현재 위치
		int ballNow = 0;
		// 1번째 친구 +1
		ballCnt[0] += 1;
		while (true) { // 1번 while문
			// 공 받은 사람의 카운트가 홀수 일때
			if (ballCnt[ballNow] % 2 == 1) {
				// ballCnt가 M이면 1번 while문 종료
				if (ballCnt[ballNow] == M)
					break;
				// 공 위치 +L
				ballNow += L;
				// 공이 ballCnt인덱스 범위 벗어나지 않게 조정
				while (ballNow > N-1) // 2-1번 while문
					ballNow -= N;
				// 현재 공 위치에 ballCnt +1 
				ballCnt[ballNow] += 1;

			} else {
				// ballCnt가 M이면 1번 while문 종료
				if (ballCnt[ballNow] == M)
					break;
				// 공 받은 사람의 카운트가 짝수 일때
				// 공 위치 -L
				ballNow -= L;
				// 공이 ballCnt인덱스 범위 벗어나지 않게 조정
				while (ballNow < 0) // 2-2번 while문
					ballNow += N;
				// 현재 공 위치에 ballCnt +1 
				ballCnt[ballNow] += 1;
			}
		}
		// 총 몇번 던졌는지 구하기 처음 받은거 제외
		int sum = -1;
		for (int i = 0; i < N; i++) {
			sum += ballCnt[i];
		}
		System.out.println(sum);
	}
}