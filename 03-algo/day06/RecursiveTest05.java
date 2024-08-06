
public class RecursiveTest05 {
	static int sum = 0;
	static int i = 0;
	// N을 받아서 1 ~ N까지 출력하는 프로그램 작성
	public static void main(String[] args) throws InterruptedException {
		int[] arr = {1, 3, 5, 7, 9};
		System.out.println("반복문을 이용함");
		System.out.println(solve1(arr, 10));
		System.out.println("재귀를 이용함");
		System.out.println(solve2(arr, 10));
	}
	private static int solve1(int[] arr, int j) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == j) {
				return i;
			}
		}
		return -1;
		
	}
	private static int solve2(int[] arr, int j) {
		if (i == arr.length) {
			return -1;
		}
		if (arr[i] == j) {
			return i;
		}
		i += 1;
		return solve2(arr, j);
	}
}
