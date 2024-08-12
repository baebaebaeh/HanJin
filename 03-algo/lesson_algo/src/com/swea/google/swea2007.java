package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class swea2007 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Character> queue = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int firstChar = str.charAt(0);
		int tempIdx = 0;
		for (int iter = 1; iter <= T; iter++) {
			for (int i = 1; i < 30; i++) {
				if (firstChar == str.charAt(i)) {
					tempIdx = i;
					for (int j = 0; j < 30 - i; j++) {
						str.charAt(tempIdx + j)
					}
				}
			}
		}
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}