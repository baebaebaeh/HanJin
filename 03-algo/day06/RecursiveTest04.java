
public class RecursiveTest04 {
	static int sum = 0;
	static int i = 0;
	// N을 받아서 1 ~ N까지 출력하는 프로그램 작성
	public static void main(String[] args) throws InterruptedException {
		int[] arr = {1, 3, 5, 7, 9};
		solve1(arr);
		System.out.println(solve2(arr)); 
//		solve1Recur(13489);
	}
	
	
	private static void solve1(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		return;
	}
	
	
	private static int solve2(int[] arr) {
		if (i == arr.length) {
			return sum;
		}
		sum += arr[i];
		i += 1;
		return solve2(arr);
	}

	private static void solve1Recur(int i) {
		if (i == 0) {
			System.out.println(sum);
			return;
		}
		sum += i % 10;
		i /= 10;
		solve1Recur(i);
	}
}
