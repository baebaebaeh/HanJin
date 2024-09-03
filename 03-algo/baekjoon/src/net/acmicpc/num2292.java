package net.acmicpc;

import java.util.Scanner;

public class num2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int range = 0;
		int num = 1;
		while (true) {
			num = range*6 + num;
			range++;
			if (N <= num) break;
		}
		System.out.println(range);
	}
}
