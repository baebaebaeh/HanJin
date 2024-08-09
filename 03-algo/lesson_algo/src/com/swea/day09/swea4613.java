package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea4613 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// [row][색깔] = M - 색개수
			//      R0 B1 W2
			int[][] map = new int[N][3];
			for (int i = 0; i < N; i++) {
				String color = br.readLine();
				int red = 0;
				int blue = 0;
				int white = 0;
				for (int j = 0; j < M; j++) {
					if (color.charAt(j) == 'R')
						red++;
					if (color.charAt(j) == 'B')
						blue++;
					if (color.charAt(j) == 'W')
						white++;
				}
				map[i][0] = M - red;
				map[i][1] = M - blue;
				map[i][2] = M - white;
			}
			
			
			
			int ans = 10000;
			int sumRed = 0;
			int sumBlue = 0;
			int sumWhite = 0;
			for (int i = 0; i < N - 2; i++) {
				sumWhite += map[i][2];
				for (int j = i + 1; j < N - 1; j++) {
					sumBlue += map[j][1];
					for (int k = j + 1; k < N; k++) {
						sumRed += map[k][0];
					}
					if (ans > sumRed + sumBlue + sumWhite) {
						ans = sumRed + sumBlue + sumWhite;
					}
					sumRed = 0;
				}
				sumBlue = 0;
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}