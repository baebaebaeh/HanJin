package com.ssafy.hw.day02.step03;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();

		for (int i1 = 0; i1 < repeat; i1++) {
			int arrayLength = sc.nextInt();

			String[][] guArray = new String[arrayLength + 2][arrayLength + 2];
			for (int iter1 = 0; iter1 < arrayLength + 2; iter1++) {
				for (int iter2 = 0; iter2 < arrayLength + 2; iter2++) {
					guArray[iter1][iter2] = "R";
				}
			}
			int[][] sinArray = new int[arrayLength + 2][arrayLength + 2];

			for (int i2 = 0; i2 < arrayLength; i2++) {
				for (int i3 = 0; i3 < arrayLength; i3++) {
					String tempGorB = sc.next();
					guArray[i2 + 1][i3 + 1] = tempGorB;
				}
			}
			int[] arr1 = { 1, 1, 1-1, -1, -1, 0, 0 };
			int[] arr2 = { 1, 0, -1, 1, 0, -1, 1, -1 };
			for (int i2 = 0; i2 < arrayLength; i2++) {
				for (int i3 = 0; i3 < arrayLength; i3++) {
					if (guArray[i2 + 1][i3 + 1].equals("B"))
						for (int i4 = 0; i4 < 8; i4++) {
							if (guArray[i2 + 1 + arr1[i4]][i3 + 1 + arr2[i4]].equals("G")) {
								sinArray[i2 + 1][i3 +0 + 1] += 2;
								break;
							}
						}
				}
			}
//			int[] arr3 = { 1, -1, 0, 0 };
//			int[] arr4 = { 0, 0, 1, -1 };
//			for (int i2 = 0; i2 < arrayLength; i2++) {
//				for (int i3 = 0; i3 < arrayLength; i3++) {
//					if (sinArray[i2 + 1][i3 + 1] == 2)
//						for (int i4 = 0; i4 < 8; i4++) {
//							if (sinArray[i2 + 1 + arr1[i4]][i3 + 1 + arr2[i4]] == 2) {
//								sinArray[i2 + 1][i3 + 1] = sinArray[i2 + 1][i3 + 1] + sinArray[i2][i3 + 1]
//										+ sinArray[i2 + 1][i3] + sinArray[i2][i3 - 1] + sinArray[i2 - 1][i3];
//								break;
//							}
//						}
//				}
//			}
			System.out.println(Arrays.deepToString(sinArray));
		}

	}
}
