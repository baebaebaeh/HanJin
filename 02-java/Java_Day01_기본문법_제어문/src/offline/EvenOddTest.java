package offline;

public class EvenOddTest {
	static boolean isEven(int n) {
		return (n & 1) == 0;
	}
	static boolean isOdd(int n) {
		return (n & 1) == 1;
	}
	public static void main(String[] args) {
		System.out.println(isEven(100) ? "100은 짝수" : "100은 홀수");
		System.out.println(isOdd(97) ? "97은 홀수" : "97은 짝수");
	}
}
