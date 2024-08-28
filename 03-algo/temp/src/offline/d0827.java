package offline;

import java.util.Arrays;

public class d0827 {
	static int N, R;
	static int[] sel;
	static int[] data;

	public static void main(String[] args) {
		N = 4;
		R = 3;
		data = new int[] { 10, 20, 30, 40 };
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합반복**********");
		부분집합반복();
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합재귀**********");
		부분집합재귀(0);
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합비트마스킹**********");
		부분집합비트마스킹();
		
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합반복문**********");
		조합반복문();
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합반복재귀**********");
		조합반복재귀(0, 0);
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합재귀**********");
		조합재귀(0, 0); // 데이터의 위치, 선택한 데이터의 위치
	}

	private static void 부분집합반복() {
		// 0이 선택 1이 미선택
		for (int i = 0; i < 2; i++) {
			sel[0] = i;
			for (int j = 0; j < 2; j++) {
				sel[1] = j;
				for (int k = 0; k < 2; k++) {
					sel[2] = k;
					for (int l = 0; l < 2; l++) {
						sel[3] = l;
						for (int n = 0; n < N; n++) {
							if (sel[n] == 0) continue;
							System.out.print(data[n] + " ");
						}
						System.out.println();
					}
				}
			}
		}
	}

	private static void 부분집합재귀(int start) {
		if (start == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i] == 0) continue;
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < 2; i++) {
			sel[start] = i;
			부분집합재귀(start + 1);
		}
	}

	private static void 부분집합비트마스킹() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) {
					System.out.print(data[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void 조합반복문() {
		for (int i = 0; i <= N - R + 0; i++) {
			for (int j = i + 1; j <= N - R + 1; j++) {
				for (int k = j + 1; k <= N - R + 2; k++) {
					System.out.println(data[i] + " " + data[j] + " " + data[k]);
				}
			}
		}
	}

	private static void 조합반복재귀(int start, int startIdx) {
		if (startIdx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = start; i <= N - R + startIdx; i++) {
			sel[startIdx] = data[i];
			조합반복재귀(i + 1, startIdx + 1);
		}
	}

	private static void 조합재귀(int start, int startIdx) {
		if (startIdx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (start == N) {
			return;
		}
		sel[startIdx] = data[start];
		조합재귀(start + 1, startIdx + 1);
		조합재귀(start + 1, startIdx);
	}
}