package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea10761 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input10761.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] robot = new int[N];
			int[] butten = new int[N];
			for (int i = 0; i < N; i++) {
				if (st.nextToken().equals("B")) {
					robot[i] = 0;
				} else {
					robot[i] = 1;
				}
				butten[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(robot));
			int[] turn = new int[N];
			int bluePosi = 1;
			int oranPosi = 1;
			for (int i = 0; i < N; i++) {
				if (robot[i] == 0) {
					turn[i] = Math.abs(butten[i] - bluePosi) + 1;
					bluePosi = butten[i];
				}
				if (robot[i] == 1) {
					turn[i] = Math.abs(butten[i] - oranPosi) + 1;
					oranPosi = butten[i];
				}
			}
			int temp = turn[0];
			for (int i = 1; i < N; i++) {
				if (robot[i] != robot[i - 1]) {
					turn[i] -= temp;
					if (turn [i] <= 0) turn[i] = 1;
					temp = 0;
				}
				temp += turn[i];
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += turn[i];
			}
//			System.out.println(Arrays.toString(turn));
//			System.out. println(sum);
			bw.write("#" + iter + " " + sum + "\n");
		}
		bw.flush();
	}
}
