package offline;

import java.util.Arrays;

public class 템플릿 {
	static int N, R;
	static int[] sel;
	static int[] data;

	public static void main(String[] args) {
		N = 4;
		R = 3;
		data = new int[] { 10, 20, 30, 40 };
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합재귀**********");
		부분집합재귀();
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합반복**********");
		부분집합반복();
		sel = new int[N]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********부분집합비트마스킹**********");
		부분집합비트마스킹();
		
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합반복문**********");
		조합반복문();
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합반복재귀**********");
		조합반복재귀();
		sel = new int[R]; // 각 자리에 선택된 값을 넣어주자
		System.out.println("**********조합재귀**********");
		조합재귀(); // 데이터의 위치, 선택한 데이터의 위치
	}

	private static void 부분집합재귀() {
		
	}

	private static void 부분집합반복() {
		
	}

	private static void 부분집합비트마스킹() {
		
	}

	private static void 조합반복문() {
		
	}

	private static void 조합반복재귀() {
		
	}

	private static void 조합재귀() {
		
	}
}