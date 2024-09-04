package com.swea.num7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class num7465 {
	static int[] parents;
	static int N, M, ans;
	static int[] count;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			parents = new int[N + 1];
			count = new int[N + 1];
			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(find(from), find(to));
			}
			for (int i = 1; i < N + 1; i++) {
				count[find(i)]++;
			}
			for (int i = 1; i < N + 1; i++) {
				if (count[i] != 0) ans++;
			}
			System.out.println("#" + iter + " " + ans);
		}
	}

	private static void union(int x, int y) {
		if (x == y) {
			return;
		}
		parents[y] = x;
	}

	private static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	private static void make() {
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
}