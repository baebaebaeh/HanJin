/*
2 5

2 * 2 * 2 * 2 * 2
 */
public class RecursiveExam01 {
	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		solve1(a, b);
	}
	static int sum = 1;
	private static void solve1(int a, int b) {
		if (b == 0) {
			System.out.println(sum);
			return;
		}
		sum *= a;
		solve1(a, b-1);
	}
}
