import java.util.Arrays;

public class 병합정렬01 {
	static int[][] arr = {{1, 1}, {2, 1}, {3, 1}, {1, 2}};
	static int N = arr.length; // 배열의 길이
	static int[][] tmp = new int[N][];

	public static void main(String[] args) {
		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	// left :구간의 시작 위치 / right : 구간의 끝
	static void mergeSort(int left, int right) {
//		if(left >= right) return;
//		int mid = (left+right)/2;
//		mergeSort(left, mid);
//		mergeSort(mid+1, right);

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	// l
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 포인트
		int R = mid + 1; // 오른쪽구간의 시작 포인트

		int idx = left; // tmp 배열의 인덱스

		while (L <= mid && R <= right) {
			if (arr[L][0] <= arr[R][0]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		// 왼쪽구간의 값이 남았어!
		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				tmp[idx++] = arr[i];
		}
		// 오른쪽구간의 값이 남았어
		else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}

		// 원본배열에 반영하자
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}
