package day03;

import java.util.Arrays;

public class 정렬 {
	public static void main(String[] args) {
		int[] arr = { 6, 4, 6, 2, 2, 1 };
		선택정렬(arr);
	}

	static void 버블정렬(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		System.out.println("버블정렬 결과 : ");
		System.out.println(Arrays.toString(arr));
	}

	static void 선택정렬(int[] arr) {
		for (int i = arr.length -1; i >= 0; i--) {
			int temp = 0;
			int maxIdx = 0;
			for (int j = 0; j <= i; j++) {
				if (arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
		System.out.println("선택정렬 결과 : ");
		System.out.println(Arrays.toString(arr));
	}
}
