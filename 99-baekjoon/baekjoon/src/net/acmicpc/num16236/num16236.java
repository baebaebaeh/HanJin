package net.acmicpc.num16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num16236 {
	static int[][] map;
	static boolean[][] visited;
	static int size, eat, N, ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		eat = 0;
		size = 2;
		ans = 0;
		visited = new boolean[N][N];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		bfs(r, c, 0);
		System.out.println(ans);
	}

	private static void bfs(int R, int C, int D) {
		map[R][C] = 0;
		// [r, c, dist]
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			return o1[2] - o2[2];
		});
		
		visited[R][C] = true;
		queue.add(new int[] { R, C, D });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int dist = now[2];
			if (map[r][c] < size &&
					map[r][c] > 0) {
				eat += 1;
				ans += dist;
				map[r][c] = 0;
				for (int i = 0; i < N; i++) {
					Arrays.fill(visited[i], false);
				}
				if (eat == size) {
					size++;
					eat = 0;
				}
				bfs(r, c, 0);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N &&
						!visited[nr][nc]) {

					if (map[nr][nc] > size) {
						continue;
					}
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, dist + 1 });
				}
			}
		}
	}
}