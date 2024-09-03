package net.acmicpc.num1600;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class num1600 {
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
		//System.setIn(new FileInputStream("data/input1600.txt"));
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		ans = 99999999;
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[H][W][K + 1];
		bfs(new int[] { 0, 0, 0, 0 }); // [r, c, 움직인 거리, 말처럼움직인 횟수]
		if (ans == 99999999)
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
			// 말처럼 갈 수 있는곳 다 queue에 넣고
			for (int d = 0; d < 8; d++) {
				if (r + dr1[d] >= 0 && c + dc1[d] >= 0
						&& r + dr1[d] < H && c + dc1[d] < W
						&& map[r + dr1[d]][c + dc1[d]] == 0 
						&& horse + 1 < K + 1
						// 말처럼 가면 visited horse + 1 부분을 먼저 도착했었으면 그만
						&& !visited[r + dr1[d]][c + dc1[d]][horse + 1]) {
					// 말처럼 가면 visited horse + 1 부분 트루로 바꿔줌
					visited[r + dr1[d]][c + dc1[d]][horse + 1] = true;
					// queue에 길이 1늘려주고, 말처럼 행동 + 1
					int[] newArr = { r + dr1[d], c + dc1[d], dist + 1, horse + 1 };
					queue.add(newArr);
				}
			}
			// 말처럼 갈 수 없는곳 다 queue에 넣어라
			for (int d = 0; d < 4; d++) {
				if (r + dr2[d] >= 0 && c + dc2[d] >= 0 
						&& r + dr2[d] < H && c + dc2[d] < W
						&& map[r + dr2[d]][c + dc2[d]] == 0 
						&& !visited[r + dr2[d]][c + dc2[d]][horse]) {
					// 그냥 가면 visited horse + 1 부분 트루로 바꿔줌
					visited[r + dr2[d]][c + dc2[d]][horse] = true;
					// queue에 길이 1늘려주고, 말처럼 행동은 그대로
					int[] newArr = { r + dr2[d], c + dc2[d], dist + 1, horse };
					queue.add(newArr);
				}
			}
		}
	}
}
