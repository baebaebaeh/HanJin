package com.swea.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class swea5432 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st1.nextToken());
		for (int iter = 1; iter <= T; iter++) {
			String st2 = br.readLine();
			int ans = 0;
			int temp1 = 0;
			int temp2 = 0;
			for (int i = 0; i < st2.length() - 1; i++) {
				if (st2.charAt(i) == '(' && st2.charAt(i+1) == ')') {
					i++;
					ans += temp1;
					continue;
				}
				if (st2.charAt(i) == '(') {
					temp1++;
					temp2++;
				}
				if (st2.charAt(i) == ')') {
					temp1--;
				}
			}
			bw.write("#" + iter + " " + (ans + temp2)+ "\n");
		}
		bw.flush();
	}
}