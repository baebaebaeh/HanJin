package net.acmicpc.num1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class num1600 {
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr1 = { -2, -2, -1, 1, 2, 2, 1, -1 }; // 상좌 상우 우상 우하 하우 하좌 좌하 좌상
	static int[] dc1 = { -1, 1, 2, 2, 1, -1, -2, -2 }; // 상좌 상우 우상 우하 하우 하좌 좌하 좌상
	static int[] dr2 = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc2 = { 0, 0, -1, 1 }; //
	static int K, H, W, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = 99999999;
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[H][W][K + 1];
		bfs(new int[] { 0, 0, 0, 0 }); // [r, c, 움직인 거리, 말처럼움직인 횟수]
		if (ans == 99999999)
			ans = -1;
		bw.write(ans + "");
		bw.flush();
	}

	private static void bfs(int[] arr) {
		queue.add(arr);
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];
			int dist = poll[2];
			int horse = poll[3];
			if (r == W - 1 && c == H - 1) {
				if (ans > dist)
					ans = dist;
			}
			visited[r][c][horse] = true;
			for (int d = 0; d < 8; d++) {
				if (r + dr1[d] >= 0 && c + dc1[d] >= 0 && r + dr1[d] < H && c + dc1[d] < W
						&& map[r + dr1[d]][c + dc1[d]] == 0 && horse + 1 >= 0 && horse + 1 < K + 1
						&& !visited[r + dr1[d]][c + dc1[d]][horse + 1]) {
					int[] newArr = { r + dr1[d], c + dc1[d], dist + 1, horse + 1 };
					queue.add(newArr);
				}
			}
			for (int d = 0; d < 4; d++) {
				if (r + dr2[d] >= 0 && c + dc2[d] >= 0 && r + dr2[d] < H && c + dc2[d] < W
						&& map[r + dr2[d]][c + dc2[d]] == 0 && !visited[r + dr2[d]][c + dc2[d]][horse]) {
					int[] newArr = { r + dr2[d], c + dc2[d], dist + 1, horse };
					queue.add(newArr);
				}
			}
		}
	}
}
