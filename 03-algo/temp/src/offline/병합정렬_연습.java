package offline;

import java.util.Arrays;

public class 병합정렬_연습 {
	static int[] arr = { 43, 12, 54, 75, 1, 5, 8 };
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
			if (arr[L] < arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		if (right < R) {
			for (int i = idx; i < N; i++) {
				temp[i] = arr[L++];
			}
		} else {
			for (int i = idx; i < N; i++) {
				temp[i] = arr[R++];
			}
		}
		for (int i = 0; i < N; i++) {
			arr[i] = temp[i];
		}
	}
}
