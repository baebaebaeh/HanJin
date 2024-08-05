package com.swea.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class swea8931 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input8931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			Stack<Integer> stack = new Stack<>();
			int ans = 0;
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < K; i++) {
				int money = Integer.parseInt(br.readLine());
				if (money != 0) {
					stack.push(money);
				} else {
					stack.pop();
				}
			}
			for (int i = stack.size() - 1; i >= 0; i--) {
				ans += stack.get(i);
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}