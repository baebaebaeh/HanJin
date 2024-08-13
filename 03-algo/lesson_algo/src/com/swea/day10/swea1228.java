package com.swea.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class swea1228 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter < 11; iter++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int temp = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < temp; i++) {
				st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				for (int j = 0; j < M; j++) {
					list.add(num + j, Integer.parseInt(st.nextToken()));
				}
			}
			bw.write("#" + iter + " ");
			for (int a = 0; a < 10; a++) {
				bw.write(list.get(a) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}