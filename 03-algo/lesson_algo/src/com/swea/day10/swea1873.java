package com.swea.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1873 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int d = 0;
	static int nowR = 0;
	static int nowC = 0;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String string = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = string.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || 
							map[i][j] == '<' || map[i][j] == '>') {
						nowR = i;
						nowC = j;
					}
				}
			}
			String string = br.readLine();
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == 'U') {
					d = 0;
					if (nowR + dr[d] < 0 || H <= nowR + dr[d]);
				}
			}
		}
		
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}