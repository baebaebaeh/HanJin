package offline;

import java.util.Arrays;
import java.util.Iterator;

public class 병합정렬_연습 {
	static int[] arr = { 2, 4, 5, 76, 4, 5, 6, 67, 8, 9 };
	static int N = arr.length;
	static int[] temp = new int[N];

	public static void main(String[] args) {
		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		if (right < R) {
			for (int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}
}
