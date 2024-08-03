import java.util.Arrays;

public class Array2_순차검색 {
	
	public static void main(String[] args) {
		int[] arr = {4, 9, 11, 23, 2, 19, 7};
		int key = 7;
		int result = searchForNoSort(arr, key);
		int result2 = searchWhileNoSort(arr, key);
		System.out.println(result);
		System.out.println(result2);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int result3 = searchForSort(arr, 10);
		System.out.println(result3);
//		searchWhileSort(arr, key);
	}
	
	// 찾고자하는 key의 index를 return
	static int searchForNoSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		// 못 찾았을 때
		return -1;
	}
	
	static int searchWhileNoSort(int[] arr, int key) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == key) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	static int searchForSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
			else if (arr[i] > key)
				return -1;
		}
		return -1;
	}
	
	static int searchWhileSort(int[] arr, int key) {
		return -1;
	}

	
	
	
	
	
	
}
