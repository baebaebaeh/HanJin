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

class test {
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
			list.add(1, 0);
			for (int a : list)
				System.out.println(a);
		}
		
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}