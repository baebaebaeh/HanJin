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

class swea1230 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter < 11; iter++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String d = st.nextToken();
				if (d.equals("I")) {
					int firstIdx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int j = 0; j < num; j++) {
						list.add(firstIdx + j, Integer.parseInt(st.nextToken()));
					}
				}
				if (d.equals("D")) {
					int firstIdx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int j = 0; j < num; j++) {
						list.remove(firstIdx);						
					}
				}
				if (d.equals("A")) {
					int num = Integer.parseInt(st.nextToken());
					for (int j = 0; j < num; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}					
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
