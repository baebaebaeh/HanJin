package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class swea4047 {
	static Set<Integer> set1;
	static Set<Integer> set2;
	static Set<Integer> set3;
	static Set<Integer> set4;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input4047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		out : for (int iter = 1; iter <= T; iter++) {
			set1 = new HashSet<>();
			set2 = new HashSet<>();
			set3 = new HashSet<>();
			set4 = new HashSet<>();
			String str = br.readLine();
			int length = str.length();
			for (int i = 0; i < length; i += 3) {
				int cardNum = 0;
				switch (str.charAt(i)) {
				case 'S':
					cardNum += (str.charAt(i + 1) - '0') * 10;
					cardNum += str.charAt(i + 2) - '0';
					set1.add(cardNum);
					break;
				case 'D':
					cardNum += (str.charAt(i + 1) - '0') * 10;
					cardNum += str.charAt(i + 2) - '0';
					set2.add(cardNum);
					break;
				case 'H':
					cardNum += (str.charAt(i + 1) - '0') * 10;
					cardNum += str.charAt(i + 2) - '0';
					set3.add(cardNum);
					break;
				case 'C':
					cardNum += (str.charAt(i + 1) - '0') * 10;
					cardNum += str.charAt(i + 2) - '0';
					set4.add(cardNum);
					break;
				}
			}
			if (str.length() / 3 != set1.size() + set2.size() + set3.size() + set4.size()) {
				bw.write("#" + iter + " ERROR" + "\n");
				continue out;
			}
			bw.write("#" + iter + " " + (13 - set1.size()) + (13 - set2.size()) + (13 - set3.size())
					+ (13 - set4.size()) + " " + "\n");
		}
		bw.flush();
	}
}