package com.swea.day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//초심자의 회문검사
class swea1989 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int iter = 1; iter <= T; iter++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			int ans = 1;
			for (int i = 0; i < A.length() / 2; i++) {
				if (A.charAt(i) != A.charAt(A.length()-1-i)) {
					ans = 0;
					break;
				}
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}