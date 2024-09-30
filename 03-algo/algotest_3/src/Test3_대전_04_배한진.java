import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test3_대전_04_배한진 {
	static int N, M, ans, sum;
	static int[] map;
	static int[] color; // 0은 빨강 1은 파랑
	static boolean[] visited;
	static int[] sel;
	static int[] drc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= testCase; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sum = 0;
			ans = Integer.MAX_VALUE;
			map = new int[N * M];
			color = new int[N * M];
			drc = new int[] {-1, 1, -M, M};
			visited = new boolean[N * M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i * M + j] = Integer.parseInt(st.nextToken());
					sum += map[i * M + j];
				}
			}
			for (int i = 1; i <= N * M / 2; i++) {
				sel = new int[N * M / 2];
				comb(0, 0, i);
			}
			System.out.println(Arrays.toString(map));
			System.out.println(ans);
		}
	}
	private static void comb(int start, int startIdx, int r) {
		if (startIdx == r) {
			for (int i = 0; i < N * M; i++) {
				if (color[i] == 0 && !visited[i]) {
					bfs(i, color[i]);					
				}
				if (color[i] == 1 && !visited[i]) {
					bfs(i, color[i]);
				}
			}
			for (int i = 0; i < N * M; i++) {
				if (!visited[i]) {
					return;
				}
			}
			int tmp = 0;
			for (int i = 0; i < r; i++) {
				tmp += sel[i];
			}
			System.out.println(Arrays.toString(sel));
			if (ans > Math.abs(sum - (tmp * 2))) {
				ans = Math.abs(sum - (tmp * 2));
			}
			return;
		}
		for (int i = start; i <= N - r + startIdx; i++) {
			sel[startIdx] = map[i];
			color[i] = 1;
			comb(i + 1, startIdx + 1, r);
			color[i] = 0;
		}
	}
	private static void bfs(int i, int clr) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int nowI = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = nowI + drc[d];
				if (ni >= 0 && ni < N*M &&
						color[ni] == clr && !visited[ni]) {
					q.add(ni);
					visited[ni] = true;
				}
			}
		}
	}
}
