package offline;
import java.util.Arrays;

public class 퀵정렬02_로무토파티션_연습 {
	static int[] arr = { 56, 12, 6, 13, 64, 1, 10};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSort(0, N-1);
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
		int temp = 0;
		for (int j = left; j < right; j++) {
			if (pivot >= arr[j]) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[right];
		arr[right] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}
}
