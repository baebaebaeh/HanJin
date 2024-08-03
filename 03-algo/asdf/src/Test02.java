import java.lang.reflect.Array;
import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 45, 65, 7, 8, 412,65 , 6, 7,43 ,7};
		Arrays.sort(a);
		System.out.println(binarySearch(a, 8));
	}

	public static int binarySearch(int[] a, int key) {
		int right = a.length-1;
		int left = 0;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (a[mid] == key)
				return mid;
			else if (a[mid] > key)
				right = mid - 1;
			else if (a[mid] < key) 
				left = mid + 1;
		}
		return -1;
	}
}
