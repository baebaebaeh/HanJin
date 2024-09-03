package net.acmicpc.num1600;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class num1600_ {
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[] dr1 = { -2, -2, -1, 1, 2, 2, 1, -1 }; // 상좌 상우 우상 우하 하우 하좌 좌하 좌상
	static int[] dc1 = { -1, 1, 2, 2, 1, -1, -2, -2 }; // 상좌 상우 우상 우하 하우 하좌 좌하 좌상
	static int[] dr2 = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc2 = { 0, 0, -1, 1 }; //
	static int K, H, W;
	static long ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1600.txt"));
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		ans = 9999999;
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[H][W][K + 1];
		bfs(new int[] { 0, 0, 0, 0 }); // [r, c, 움직인 거리, 말처럼움직인 횟수]
		if (ans == 9999999)
			ans = -1;
		System.out.println(ans);
	}

	private static void bfs(int[] arr) {
		queue.add(arr);
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];
			int dist = poll[2];
			int horse = poll[3];
			if (r == H - 1 && c == W - 1) {
				if (ans > dist)
					ans = dist;
			}
			for (int d = 0; d < 8; d++) {
				int nr = r + dr1[d];
				int nc = c + dc1[d];
				if (horse < K
						&& nr >= 0 && nc >= 0 && nr < H && nc < W 
						&& map[nr][nc] == 0 
						&& !visited[nr][nc][horse + 1]) {
					visited[nr][nc][horse + 1] = true;
					queue.add(new int[] { nr, nc, dist + 1, horse + 1 });
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr2[d];
				int nc = c + dc2[d];
				if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] == 0 && !visited[nr][nc][horse]) {
					visited[nr][nc][horse] = true;
					queue.add(new int[] { nr, nc, dist + 1, horse });
				}
			}
		}
	}
}
