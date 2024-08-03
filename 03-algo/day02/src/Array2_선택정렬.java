import java.util.Arrays;

public class Array2_선택정렬 {

	public static void main(String[] args) {
		
		int[] nums = {10, 64, 25, 11, 28, 77, 34};
		
		selectionSort(nums);
		
		System.out.println(Arrays.toString(nums));

	}
	
	static void selectionSort(int[] arr) {
		// cycle 횟수 : 배열 길이 - 1
		for (int i = 0; i < arr.length; i++) {
			// 최솟값의 인덱스를 저장할 변수
			int minIdx = i;
			// 최솟값을 찾는 반복문
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			// i와 minIdx의 위치 변경 (swap)
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}
}
