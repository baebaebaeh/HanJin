package net.acmicpc.num17135;

import java.util.*;
import java.io.*;

public class num17135 {
	static int N, M, D, ans, tmpAns;
	static int[][] map;
	static int[] sel;
	static int[] dr = { 0, -1, 0 };
	static int[] dc = { -1, 0, 1 };
	static boolean[][] visited;
	static int[][] kill;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		for (int iter = 1; iter <= 8; iter++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ans = 0;
		sel = new int[3];
		map = new int[N][M];
		visited = new boolean[N][M];
		kill = new int[3][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combBfs(0, 0);
		System.out.println(ans);
	}
//	}

	private static void combBfs(int start, int startIdx) {
		if (startIdx == 3) {
//			System.out.println(Arrays.toString(sel));
			tmpAns = 0;
			int[][] m = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					m[i][j] = map[i][j];
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					kill[j] = bfs(N - i, sel[j], m);
					for (int k = 0; k < N; k++) {
						Arrays.fill(visited[k], false);
					}
				}
				for (int j = 0; j < 3; j++) {
					if (kill[j][0] == -1) {
						continue;
					}
					if (m[kill[j][0]][kill[j][1]] == 1) {
						m[kill[j][0]][kill[j][1]] = 0;
						tmpAns++;
					}
				}
			}
			if (tmpAns > ans)
				ans = tmpAns;
			return;
		}
		for (int i = start; i <= M - 3 + startIdx; i++) {
			sel[startIdx] = i;
			combBfs(i + 1, startIdx + 1);
		}
	}

	private static int[] bfs(int R, int C, int[][] m) {
		int dist = 1;
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				return o1[2] - o2[2];
			}
			return o1[2] - o2[2];
		});
		q.add(new int[] { R, C }); // r, c, 거리
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];
				if (m[r][c] == 1) {
					return now;
				}
				for (int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, dist });
					}
				}
			}
			dist++;
			if (dist > D)
				break;
		}
		return new int[] {-1, -1};
	}
}