package net.acmicpc.num17822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num17822 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input17822.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Arrays.deepToString(map));
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 배수
		int d = Integer.parseInt(st.nextToken()); // 방향
		int k = Integer.parseInt(st.nextToken()); // 몇번
		
		if (d == 0) {
			k = N - k;
		}
		int temp = 0;
		for (int i = x - 1; i < N; i += x) {
			int[] replace = new int[M];
			for (int j = 0; j < M; j++) {
				temp = j + k;
				temp %= M;
				replace[j] = map[i][temp];
			}
			map[i] = replace;
		}
		System.out.println(Arrays.deepToString(map));
	}
}