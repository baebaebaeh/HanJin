package net.acmicpc.num14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num14502_solution {
	private static final int EMPTY = -1;
	private static final int WALL = 0;
	private static final int VIRUS = 1;
	
	private static int n, m, size, max, cnt, ans;
	private static int[] map;
	private static boolean[] copy, visited;
	private static ArrayList<Integer> viruses;
	
	private static void dfs(int pos) {
		if (visited[pos] || map[pos] == WALL) {
			return;
		}
		visited[pos] = true;
		cnt++;
		dfs(pos - size);
		dfs(pos + size);
		dfs(pos - 1);
		dfs(pos + 1);
	}
	
	private static int infect() {
		cnt = 0;
		System.arraycopy(copy, 0, visited, 0, max);
		for (int virus : viruses) {
			dfs(virus);
		}
		return cnt;
	}
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int sum, pos, range, i, j, k;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		size = m + 2;
		max = (n + 2) * (m + 2);
		sum = 0;
		map = new int[max];
		viruses = new ArrayList<>();
		for (i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 1; j <= m; j++) {
				map[pos = i * size + j] = Integer.parseInt(st.nextToken()) - 1;
				if (map[pos] == EMPTY) {
					sum++;
				} else if (map[pos] == VIRUS) {
					sum++;
					viruses.add(pos);
				}
			}
		}
		range = max - size - 1;
		copy = new boolean[max];
		visited = new boolean[max];
		ans = 0;
		sum -= 3;
		for (i = size + 1; i < range; i++) {
			if (map[i] != EMPTY) {
				continue;
			}
			map[i] = WALL;
			for (j = i + 1; j < range; j++) {
				if (map[j] != EMPTY) {
					continue;
				}
				map[j] = WALL;
				for (k = j + 1; k < range; k++) {
					if (map[k] != EMPTY) {
						continue;
					}
					map[k] = WALL;
					ans = Math.max(ans, sum - infect());
					map[k] = EMPTY;
				}
				map[j] = EMPTY;
			}
			map[i] = EMPTY;
		}
		System.out.print(ans);
	}
}