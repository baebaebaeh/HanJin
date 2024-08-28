package offline;
import java.util.Arrays;

public class 퀵정렬02_로무토파티션_연습 {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length; // 배열의 길이

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
		int i = left - 1;
		int j = left;
		int pivot = arr[right];
		int tmp;
		for (; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
		tmp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[right] = arr[i + 1];
		return i + 1;
	}
}
