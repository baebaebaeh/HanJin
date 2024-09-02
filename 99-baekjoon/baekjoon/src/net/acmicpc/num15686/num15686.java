package net.acmicpc.num15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class num15686 {
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> start;
	static ArrayList<int[]> end;
	static PriorityQueue<Integer> chicken; // [[거리,
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		start = new ArrayList<>();
		visited = new boolean[N][N];
		chicken = new PriorityQueue<>((o1, o2) -> {
			return o1 - o2;
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					start.add(new int[] { i, j });
				if (map[i][j] == 2)
					end.add(new int[] { i, j });
			}
		}
		for (int i = 0; i < start.size(); i++) {
			int dist = bfs(start.get(i)[0], start.get(i)[1], 0);
			chicken.add(dist);
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[j], false);
			}
		}
		int sum = 0;
		for (int i = 0; i < M; i++) {
			sum += chicken.poll();
		}
		System.out.println(sum / M);
	}

	private static int bfs(int r, int c, int dist) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.add(new int[] { r, c, dist });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nr = now[0];
			int nc = now[1];
			int ndist = now[2];
			if (map[nr][nc] == 1) {
				return ndist;
			}
			for (int d = 0; d < 4; d++) {
				if (nr + dr[d] >= 0 && nr + dr[d] < N 
						&& nc + dc[d] >= 0 && nc + dc[d] < N
						&& !visited[nr + dr[d]][nc + dc[d]]) {
					visited[nr + dr[d]][nc + dc[d]] = true;
					queue.add(new int[] { nr + dr[d], nc + dc[d], ndist + 1 });
				}

			}
		}
		return -1;
	}
}