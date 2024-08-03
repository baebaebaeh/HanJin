package com.ssafy.hw.day02.step03;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputNumN = sc.nextInt();
		int inputNumM = sc.nextInt();

		int[] toggleArray = new int[inputNumM];

		for (int iter = 0; iter < inputNumM; iter++) {
			int inputTemp = sc.nextInt();
			toggleArray[iter] = inputTemp;
		}
		// toggleArray = [3 5 2]

		int[] switchArray = new int[inputNumN];

		for (int iter = 1; iter <= inputNumM; iter++) {
			for (int input : toggleArray) {
				int onOffRepeat = inputNumN / input;
				for (int i = 1; i <= onOffRepeat; i++) {
					switchArray[input * i - 1] += 1;
				}
			}
		}
		int j = 0;
		for (int i : switchArray) {

			if (i % 2 == 0) {
				switchArray[j] = 0;
			} else {
				switchArray[j] = 1;
			}
			j++;
		}
		for (int i : switchArray)
		System.out.printf("%-2d",i);
	}
}
