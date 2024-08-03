package com.ssafy.ws.day01.step03;

public class DigitTest2 {
	public static void main(String[] args) {
		final int N = 5;
		int emptyCnt = 0, num = 0;
		for (int i = 0; i < N; i++) {
			if (emptyCnt > 0) {
				System.out.printf("%" + 3 * emptyCnt + "s", " ");
			}
			for (int j = 0; j < N - emptyCnt * 2; j++) {
				System.out.printf("%3d", ++num);
			}
			System.out.println();
			
			if (i < N / 2) emptyCnt++;
			else emptyCnt--;
		}
	}
}