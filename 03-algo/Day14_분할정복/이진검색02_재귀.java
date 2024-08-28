import java.util.Arrays;

public class 이진검색02_재귀 {
	static int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
	static int key = 19;

	public static void main(String[] args) {
		binarySearch(0, arr.length - 1);
		
//		Arrays.binarySearch(null, 0)
	}

	static boolean binarySearch(int left, int right) {
		// 기저조건
		if (left > right) {
			return false;
		}
		// 재귀부분
		int mid = (left + right) / 2;
		if (arr[mid] == key) return true;
		else if (arr[mid] > key)
			return binarySearch(left, mid - 1);
		else {
			return binarySearch(mid + 1, right);
		}
					
	}
}