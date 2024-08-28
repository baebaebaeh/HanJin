
public class 거듭제곱02_분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
	}

	// 계산량이 많음 비효율
	public static int pow(int C, int N) {
		// 기저조건
		if (N == 1) return C;
		// 재귀부분 : 짝수인 경우, 홀수인 경우
		if (N % 2 == 0) {
			return pow(C, N / 2) * pow(C, N / 2);
		} else {
			return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2) * C;
		}
	}
	// 효율
	public static int pow2(int C, int N) {
		// 기저조건
		if (N == 1) return C;
		// 재귀부분 : 짝수인 경우, 홀수인 경우
		if (N % 2 == 0) {
			int tmp = pow(C, N / 2);
			return tmp * tmp;
		} else {
			int tmp = pow(C, (N - 1) / 2);
			return tmp * tmp * C;
		}
	}
}
