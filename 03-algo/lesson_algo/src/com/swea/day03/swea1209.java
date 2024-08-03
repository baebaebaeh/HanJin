package com.swea.day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1209 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("data/input1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int iter = 1; iter < 11; iter++) {
			br.readLine(); // 한줄 넘기기
			//초기 sum, max만들기
			int sum = 0;
			int sum1 = 0;
			int sum2 = 0;
			int max = 0;
			//map에 집어넣기
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				sum = 0;
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					sum += map[i][j];
				}
				if (max < sum) max = sum;
			}
			for (int j = 0; j < 100; j++) {
				sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += map[i][j];
					if (i == j) sum1 += map[i][j];
					if (i == -j) sum2 += map[i][j];
				}
				if (max < sum) max = sum;
				if (max < sum1) max = sum1;
				if (max < sum2) max = sum2;
			}
			bw.write("#" + iter + " " + Integer.toString(max) + "\n");
			bw.flush();
		}
	}
}