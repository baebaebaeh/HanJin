
public class Array_선택정렬 {
	public static void main(String[] args) {
		int[] nums = {10 , 65, 74, 84, 14};
		selectionSort(nums);
	}
	
	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i +1; j  < arr.length; j++) {
				if (arr [minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	
	}
}
