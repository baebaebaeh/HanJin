
public class Array2_이진검색 {

	public static void main(String[] args) {
		
		int[] nums = {2, 4, 7, 9, 11, 19, 23, 30};
		
		int result = binarySearch(nums, 1);
		System.out.println(result);

	}
	
	/*
	left -> <- right 서로 가까워짐
	left == right // 데이터 하나
	right left 역전되는 경우 멈춘다
	*/
	static int binarySearch(int[] arr, int key) {
		int left = 0; //구간의 시작 index
		int right = arr.length - 1; // 구간의 끝 index
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
