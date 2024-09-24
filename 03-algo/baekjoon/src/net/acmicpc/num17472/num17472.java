package net.acmicpc.num17472;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import 그래프최소비용01_크루스칼.Edge;
class Edge implements Comparable<Edge> {
	int A, B, W;

	public Edge(int a, int b, int w) {
		super();
		A = a;
		B = b;
		W = w;
	}

	@Override
	public String toString() {
		return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return this.W - o.W;
//		return Integer.compare(this.W, o.W);
	}
}
public class num17472 {
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, tmp;
	static Edge[] arr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = 1;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		arr = new Edge[tmp - 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					check(i, j);
				}
			}
		}
		
		for (Edge e : arr) {
			System.out.println(e);
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	private static void check(int row, int col) {
		int now = map[row][col];
		out : for (int d = 0; d < 4; d++) {
			int r = row;
			int c = col;
			int len = 0;
			while (true) {
				r = r + dr[d];
				c = c + dc[d];
				len += 1;
				if (r < 0 || r >= N || c < 0 || c >= M
						|| map[r][c] == now) {
					continue out;
				}
				if (map[r][c] > now) {
					break;
				}
			}
			Edge e = new Edge(now - 1, map[r][c], len - 1);
			arr[now - 2] = e;
		}
	}

	private static void bfs(int row, int col) {
		tmp++;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {row, col});
		map[row][col] = tmp;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M
						&& map[nr][nc] == 1) {
					q.add(new int[] {nr, nc});
					map[nr][nc] = tmp;
				}
			}
		}
	}
	
	private static void makeSet(int x) {
		
	}
}