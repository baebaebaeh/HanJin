package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class swea1926 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String st = i + "";
			String temp = "";
			for (int j = 0; j < st.length(); j++) {
				if (st.charAt(j) == '3' || st.charAt(j) == '6' ||
						st.charAt(j) == '9') {
					temp += "-";
				}
			}
			if (temp == "") {
				bw.write(i + " ");
			} else {
				bw.write(temp + " ");
			}
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}