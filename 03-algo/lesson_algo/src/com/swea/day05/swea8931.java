package com.swea.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*
문제 : 8931
메모리 : 42996 kb
시간 : 290 ms
코드길이 : 750
설명 : 받은돈이 0이 아니면 stack에 담고 0이면 stack에서 pop.
마지막에 stack에 남아있는 값을 모두 더한 값 출력.
*/

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
				if (money != 0) { // 받은 돈이 0이 아닐때
					stack.push(money);
				} else { // 0일때
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