package offline;
import java.util.Arrays;

public class 순열03_방문체크_연습 {
	static int[] nums = new int[] { 0, 1, 2 };
	static int N = nums.length;
	static boolean[] visited = new boolean[N];
	static int[] result = new int[N];

	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;

		}
	}
}
