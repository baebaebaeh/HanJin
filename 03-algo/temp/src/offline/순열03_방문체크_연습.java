package offline;
import java.util.Arrays;
import java.util.Iterator;

public class 순열03_방문체크_연습 {
	static int[] arr = { 1, 2, 3, 4 };
	static int N = arr.length;
	static boolean[] visited = new boolean[N];
	static int[] ans = new int[N];
	
	public static void main(String[] args) {
		perm(0);
	}

	private static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if () {
				
			}
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
