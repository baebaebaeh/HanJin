package net.acmicpc;

import java.util.Scanner;

public class num2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람 스캔
		int N = sc.nextInt(); // 사람수
		sc.nextLine();
		String seat = sc.next();
		int couple = 0; // 커플석개수
		int i = 0;
		while (i < N) {
			if (seat.charAt(i) == 76) { // 현재값이 L이면
				i++; // 다음 L값 뛰어넘고
				couple++; // 커플석 +1
			}
			i++;
		}
		if (couple > 0) couple -= 1;
		System.out.println(N-couple); // 
	}
}
