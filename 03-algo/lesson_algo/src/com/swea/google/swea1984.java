package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1984 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1984.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = 0;
			int max = 0;
			for (int i = 0; i < 10; i++) {
			}
		}
		
		
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}