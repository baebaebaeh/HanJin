package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class swea1289 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st1.nextToken());
		for (int iter = 1; iter <= T; iter++) {
			int ans = 0;
			String st2 = br.readLine();
			// 1로 시작하면 +1
			if (st2.charAt(0) == '1') ans += 1;
			// 인덱스 1부터 시작
			for (int i = 1; i < st2.length(); i++) {
				// 전 인덱스와 현인덱스가 같으면 +1
				if (st2.charAt(i) != st2.charAt(i - 1)) ans += 1;
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}