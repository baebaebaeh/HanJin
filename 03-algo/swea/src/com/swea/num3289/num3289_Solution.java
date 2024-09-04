package com.swea.num3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num3289_Solution {
	static int[] parents;
	static int N, M;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				make();
				switch (op) {
				case 0: // 합치기
					union(x, y);
					break;
				case 1: // 두 집합이 같은지 체크, 두 집합이 같으면 1 다르면 0을 출력
					if (find(x) == find(y)) {
						bw.write("1");
					} else {
						bw.write("0");
					}
				}
			}
			bw.flush();
		}
	}
	private static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return false; // 이미 같은 집합이다.
		
		parents[yRoot] = xRoot;
		return true; // 다른 두 집합을 합쳤다.
	}
	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}