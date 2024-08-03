package com.swea.day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1213 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter < 11; iter++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			st = new StringTokenizer(br.readLine());
			String m = st.nextToken();
			int ans = 0;
			out : for (int i = 0; i < m.length() - (n.length() - 1); i++) {
				int a = i;
				for (int j = 0; j < n.length(); j++) {
					if (m.charAt(a++) != n.charAt(j)) {
						continue out;
					}
				}
				ans += 1;
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}