package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class num2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] N = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			N[i] = sc.nextInt();
			sum += N[i];
		}
		out: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j && sum - N[i] - N[j] == 100) {
					N[i] = 0;
					N[j] = 0;
					int[] temp = new int[7];
					for (int k = 0, l = 0; k < 9; k++) {
						if (N[k] != 0)
						temp[l++] = N[k];
					}
					Arrays.sort(temp);
					for (int a : temp)
						System.out.println(a);
					break out;
				}
			}
		}
	}
}