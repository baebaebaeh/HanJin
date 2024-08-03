package net.acmicpc;

import java.util.Scanner;

public class num2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 카드 스캔
		int N = sc.nextInt(); // 카드개수
		int M = sc.nextInt(); // 최대카드합
		int[] card = new int[N]; // 카드숫자
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		int prev = 0;
		for (int i = 0; i < N - 2; i++) { // 첫번째 카드 선택
			for (int j = i + 1; j < N - 1; j++) { // 두번째 카드 선택
				for (int k = j + 1; k < N; k++) { // 세번째 카드 선택
					if (card[i] + card[j] + card[k] - M <= 0 && // 카드 합이 M을 넘지 않고
							card[i] + card[j] + card[k] > prev) { // 카드 합이 이전값보다 클때
						prev = card[i] + card[j] + card[k]; // 업데이트
					}
				}
			}
		}

		System.out.println(prev);
	}
}
