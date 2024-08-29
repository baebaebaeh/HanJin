package com.swea.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea6808 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] arr3;
	static int[] arr4;
	static int[] result;
	static boolean[] visited;
	static int win, lose;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input6808.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int[] arr1 = new int[19];
			int[] arr2 = new int[19];
			visited = new boolean[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = 0;
			for (int i = 0; i < 9; i++) {
				temp = Integer.parseInt(st.nextToken());
				arr1[temp]++;
			}
			for (int i = 1; i < 19; i++) {
				if (arr1[i] == 0) {
					arr2[i]++;
				}
			}
			arr3 = new int[9];
			arr4 = new int[9];
			result = new int[9];
			win = 0;
			lose = 0;
			int j = 0;
			int k = 0;
			for (int i = 1; i < 19; i++) {
				if (arr1[i] == 1) {
					arr3[j++] = i;
				} else {
					arr4[k++] = i; 
				}
			}
			perm(0);
			
			System.out.println("#" + iter + " " + win + " " + lose);
		}
	}
	static void perm(int idx) {
		if (idx == 9) {
			int temp1 = 0;
			int temp2 = 0;
			for (int i = 0; i < 9; i++) {
				if (arr3[i] - result[i] > 0 ) {
					temp1 += arr3[i] + result[i];
				} else {
					temp2 += arr3[i] + result[i];
				}
			}
			if (temp1 > temp2) win++;
			if (temp1 < temp2) lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue; 
			result[idx] = arr4[i];
			visited[i] = true;
			perm(idx + 1); 
			visited[i] = false; 
		}
	}
}