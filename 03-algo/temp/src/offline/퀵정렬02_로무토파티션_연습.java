package offline;

import java.util.Arrays;

public class 퀵정렬02_로무토파티션_연습 {
	static int[] arr = { 2, 45, 76, 8, 9, 43, 21, 9 };
	static int N = arr.length;

	public static void main(String[] args) {
		quickSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	private static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (pivot >= arr[j]) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[right] = temp;
		return i + 1;
	}
}
