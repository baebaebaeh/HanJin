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
		int T = Integer.parseInt(br.readLine());
		out2 : for (int iter = 1; iter <= T; iter++) {
 			String str = br.readLine();
			int firstChar = str.charAt(0);
			int i = 0;
			out: for (i = 1; i < 30; i++) {
				if (firstChar != str.charAt(i))
					continue;
				if (firstChar == str.charAt(i)) {
					for (int j = 0; j < i; j++) {
						if (i + j >= 30) {
							bw.write("#" + iter + " 0" + "\n");
							continue out2;							
						}
						if (str.charAt(i + j) != str.charAt(j))
							continue out;
					}
				}
				break;
			}
			bw.write("#" + iter + " " + i + "\n");
		}
		bw.flush();
	}
}