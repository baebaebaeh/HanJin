
public class RecursiveTest03 {
	// N을 받아서 1 ~ N까지 출력하는 프로그램 작성
	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		System.out.println("반복문을 활용한 합 구하기");
		System.out.println(solve2(N));
		System.out.println("재귀를 활용한 합 구하기");
		System.out.println(solve1(N));
		System.out.println("재귀를 활용한 합 구하기2");
		solve3(N, 0);
		solve4(N);
		sum = 0;
		solve5(1, N);
	}


	private static int solve1(int n) {
		if (n == 1) {
			return 1;
		}
		return n + solve1(n - 1);
	}
	private static int solve2(int n) {
		int sum =0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	private static void solve3(int n, int sum) {
		if (n == 0) {
			System.out.println(sum);
			return;
		}
		solve3(n - 1, sum + n);
	}
	static int sum = 0;
	private static void solve4(int n) {
		if (n == 0) {
			System.out.println(sum);
			return;
		}
		sum += n;
		solve4(n - 1);
	}
	private static void solve5(int i, int n) {
		if (i > n) {
			System.out.println(sum);
			return;
		}
		sum += i;
		solve5(i+1, n);
	}
}
