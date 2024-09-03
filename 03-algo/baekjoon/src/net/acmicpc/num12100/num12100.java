package net.acmicpc.num12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	int up = -1;
	int down = -1;
	int left = -1;
	int right = -1;

	void setChild(int a) {
		if (this.up == -1)
			this.up = a;
		else if (this.down == -1)
			this.down = a;
		else if (this.left == -1)
			this.left = a;
		else if (this.right == -1)
			this.right = a;
	}
}

public class num12100 {
	static boolean[] visited;
	static int[][] map;
	static Node[] node;
	static int count = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input12100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		node = new Node[1366];// 등비수열의 합공식
		for (int i = 1; i <= 1365; i++) {
			node[i] = new Node();
		}
		int temp = 2;
		for (int i = 1; i <= 341; i++) { // 등비수열의 합공식 한단계 위까지
			for (int j = 1; j <= 4; j++) {
				node[i].setChild(temp);
				temp++;
			}
		}
		dfs(map, 1);
		System.out.println(max);
	}

	private static void dfs(int[][] map, int i) {

		max = Math.max(max, findMax(map));
		if (node[i].up != -1) {
			int[][] newMap = move(map, 0);
			dfs(newMap, node[i].up);
		}
		if (node[i].down != -1) {
			int[][] newMap = move(map, 1);
			dfs(newMap, node[i].down);
		}
		if (node[i].left != -1) {
			int[][] newMap = move(map, 2);
			dfs(newMap, node[i].left);
		}
		if (node[i].right != -1) {
			int[][] newMap = move(map, 3);
			dfs(newMap, node[i].right);
		}
	}

	private static int[][] move(int[][] map, int d) {
		if (d == 0) {
			int len = map.length;
			int[][] newMap = new int[len][len];
			for (int c = 0; c < len; c++) {
				int tempidx = 0;
				int num = -1;
				for (int r = 0; r < len; r++) {
					if (map[r][c] == 0) continue;
					if (num == map[r][c]) {
						newMap[tempidx - 1][c] = 2 * map[r][c];
						num = -1;
					} else {
						num = map[r][c];
						newMap[tempidx][c] = map[r][c];
						tempidx++;
					}
				}
			}
			return newMap;
		}
		if (d == 1) {
			int len = map.length;
			int[][] newMap = new int[len][len];
			for (int c = len - 1; c >= 0; c--) {
				int tempidx = len - 1;
				int num = -1;
				for (int r = len - 1; r >= 0; r--) {
					if (map[r][c] == 0) continue;
					if (num == map[r][c]) {
						newMap[tempidx + 1][c] = 2 * map[r][c];
						num = -1;
					} else {
						num = map[r][c];
						newMap[tempidx][c] = map[r][c];
						tempidx--;
					}
				}
			}
			return newMap;
		}
		if (d == 2) {
			int len = map.length;
			int[][] newMap = new int[len][len];
			for (int r = 0; r < len; r++) {
				int tempidx = 0;
				int num = -1;
				for (int c = 0; c < len; c++) {
					if (map[r][c] == 0) continue;
					if (num == map[r][c]) {
						newMap[r][tempidx - 1] = 2 * map[r][c];
						num = -1;
					} else {
						num = map[r][c];
						newMap[r][tempidx] = map[r][c];
						tempidx++;
					}
				}
			}
			return newMap;
		}
		if (d == 3) {
			int len = map.length;
			int[][] newMap = new int[len][len];
			for (int r = len - 1; r >= 0; r--) {
				int tempidx = len - 1;
				int num = -1;
				for (int c = len - 1; c >= 0; c--) {
					if (map[r][c] == 0) continue;
					if (num == map[r][c]) {
						newMap[r][tempidx + 1] = 2 * map[r][c];
						num = -1;
					} else {
						num = map[r][c];
						newMap[r][tempidx] = map[r][c];
						tempidx--;
					}
				}
			}
			return newMap;
		}
		return null;
	}

	private static int findMax(int[][] map) {
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
}