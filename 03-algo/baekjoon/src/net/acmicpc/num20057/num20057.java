package net.acmicpc.num20057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class num20057 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][] map;
	static int N;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input20057.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int k = 1;
		int temp = 0;
		int r = N / 2;
		int c = N / 2;
		int d = 0;
		for (int i = 0; i < 2 * N - 2; i++) {
			for (int j = 0; j < k; j++) {
				r += dr[d];
				c += dc[d];
				move(d, r, c);
			}
			temp++;
			if (temp == 2)
				temp %= 2;
			if (temp == 0)
				k++;
			d++;
			d %= 4;
		}
		k--;
		for (int j = 0; j < k; j++) {
			r += dr[d];
			c += dc[d];
			move(d, r, c);
		}
		bw.write(ans + "");
		bw.flush();
	}

	static void move(int nowd, int r, int c) {
		int a = map[r][c];
		int sand = map[r][c];
		int[] d = new int[4];
		for (int i = 0; i < 4; i++) {
			d[i] = nowd;
			nowd++;
			nowd %= 4;
		}
		if (r + 2 * dr[d[0]] >= 0 && r + 2 * dr[d[0]] < N && c + 2 * dc[d[0]] >= 0 && c + 2 * dc[d[0]] < N) {
			map[r + 2 * dr[d[0]]][c + 2 * dc[d[0]]] += sand * 5 / 100;
		} else {
			ans += sand * 5 / 100;
		}
		a -= sand * 5 / 100;

		if (r + dr[d[1]] >= 0 && r + dr[d[1]] < N && c + dc[d[1]] >= 0 && c + dc[d[1]] < N) {
			map[r + dr[d[1]]][c + dc[d[1]]] += sand * 7 / 100;
		} else {
			ans += sand * 7 / 100;
		}
		a -= sand * 7 / 100;
		if (r + dr[d[3]] >= 0 && r + dr[d[3]] < N && c + dc[d[3]] >= 0 && c + dc[d[3]] < N) {
			map[r + dr[d[3]]][c + dc[d[3]]] += sand * 7 / 100;
		} else {
			ans += sand * 7 / 100;
		}
		a -= sand * 7 / 100;

		if (r + 2 * dr[d[1]] >= 0 && r + 2 * dr[d[1]] < N && c + 2 * dc[d[1]] >= 0 && c + 2 * dc[d[1]] < N) {
			map[r + 2 * dr[d[1]]][c + 2 * dc[d[1]]] += sand * 2 / 100;
		} else {
			ans += sand * 2 / 100;
		}
		a -= sand * 2 / 100;
		if (r + 2 * dr[d[3]] >= 0 && r + 2 * dr[d[3]] < N && c + 2 * dc[d[3]] >= 0 && c + 2 * dc[d[3]] < N) {
			map[r + 2 * dr[d[3]]][c + 2 * dc[d[3]]] += sand * 2 / 100;
		} else {
			ans += sand * 2 / 100;
		}
		a -= sand * 2 / 100;

		if (r + dr[d[0]] + dr[d[3]] >= 0 && r + dr[d[0]] + dr[d[3]] < N && c + dc[d[0]] + dc[d[3]] >= 0
				&& c + dc[d[0]] + dc[d[3]] < N) {
			map[r + dr[d[0]] + dr[d[3]]][c + dc[d[0]] + dc[d[3]]] += sand * 10 / 100;
		} else {
			ans += sand * 10 / 100;
		}
		a -= sand * 10 / 100;
		if (r + dr[d[0]] + dr[d[1]] >= 0 && r + dr[d[0]] + dr[d[1]] < N && c + dc[d[0]] + dc[d[1]] >= 0
				&& c + dc[d[0]] + dc[d[1]] < N) {
			map[r + dr[d[0]] + dr[d[1]]][c + dc[d[0]] + dc[d[1]]] += sand * 10 / 100;
		} else {
			ans += sand * 10 / 100;
		}
		a -= sand * 10 / 100;

		if (r + dr[d[2]] + dr[d[3]] >= 0 && r + dr[d[2]] + dr[d[3]] < N && c + dc[d[2]] + dc[d[3]] >= 0
				&& c + dc[d[2]] + dc[d[3]] < N) {
			map[r + dr[d[2]] + dr[d[3]]][c + dc[d[2]] + dc[d[3]]] += sand / 100;
		} else {
			ans += sand / 100;
		}
		a -= sand / 100;
		if (r + dr[d[2]] + dr[d[1]] >= 0 && r + dr[d[2]] + dr[d[1]] < N && c + dc[d[2]] + dc[d[1]] >= 0
				&& c + dc[d[2]] + dc[d[1]] < N) {
			map[r + dr[d[2]] + dr[d[1]]][c + dc[d[2]] + dc[d[1]]] += sand / 100;
		} else {
			ans += sand / 100;
		}
		a -= sand / 100;

		if (r + dr[d[0]] >= 0 && r + dr[d[0]] < N && c + dc[d[0]] >= 0 && c + dc[d[0]] < N) {
			map[r + dr[d[0]]][c + dc[d[0]]] += a;
		} else {
			ans += a;
		}
		map[r][c] = 0;
	}
}