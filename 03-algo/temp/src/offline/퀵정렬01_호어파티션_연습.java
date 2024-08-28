package offline;
import java.util.Arrays;

public class 퀵정렬01_호어파티션_연습 {
	static int[] arr = {1,3,6,7,9};
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
		int pivot = arr[left];
		int i = left + 1;
		int j = right;
		while (i <= j) {
			while (i <= j && arr[j] > pivot)
				j--;
			while (i <= j && arr[i] <= pivot)
				i++;
			if (i < j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		arr[left] = arr[j];
		arr[j] = pivot;
		return i;
	}
}
