package net.acmicpc;

import java.util.Scanner;

public class num2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = -100;
		int prev = 0;
		int i = 0;
		while(sum < 0) {
			prev = sum;
			sum += sc.nextInt(); // 합이 100이 넘을때 까지 다음 값을 더해라
			i++;
			if (i == 10) break;
		}
		if (Math.abs(prev) < Math.abs(sum)) { // 이전값이 0에 가까우면
			sum = prev; // 답을 이전값으로 바꿔라
		}
		System.out.println(sum+100);
	}
}
