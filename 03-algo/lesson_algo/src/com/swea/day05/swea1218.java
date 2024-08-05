package com.swea.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1218 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter <= 10; iter++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st1.nextToken());
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			String st2 = br.readLine();
			for (int i = 0; i < len; i++) {
				if (st2.charAt(i) == '(') a++;
				if (st2.charAt(i) == ')') a--;
				if (st2.charAt(i) == '[') b++;
				if (st2.charAt(i) == ']') b--;
				if (st2.charAt(i) == '{') c++;
				if (st2.charAt(i) == '}') c--;
				if (st2.charAt(i) == '<') d++;
				if (st2.charAt(i) == '>') d--;
			}
			bw.write("#" + iter + " ");
			if (a == 0 && b == 0 && c == 0 && d == 0) {
				bw.write("1" + "\n");
			} else {
				bw.write("0" + "\n");
			}
		}
		bw.flush();
	}
}