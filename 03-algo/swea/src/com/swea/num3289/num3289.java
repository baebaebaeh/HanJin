package com.swea.num3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num3289 {
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
				if (op == 0) {
					union(x, y);
				}
			}
		}
	}
	private static void find(int x) {
		
	}
	private static void union(int xRoot, int yRoot) {
		parents[yRoot] = xRoot;
	}
	private static void make() {
		for (int i = 0; i <= N; i++) {
			parents[i] = i;			
		}
	}
}