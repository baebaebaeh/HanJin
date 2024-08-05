package com.swea.day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class swea5432_stack {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st1.nextToken());
		for (int iter = 1; iter <= T; iter++) {
			Stack<Character> stack = new Stack<>();
			String st2 = br.readLine();
			// 쇠막대기가 잘린 횟수
			int ans = 0;
			// 쇠막대기 개수
			int temp = 0;
			// 마지막에 '(' 가 안나오기 때문에 길이만큼 반복
			for (int i = 0; i < st2.length(); i++) {
				// 레이저 일때
				if (st2.charAt(i) == '(' && 
						st2.charAt(i + 1) == ')') {
					// i를 한칸 띄워주고
					i++;
					ans += stack.size();
					continue;
				}
				// 레이저가 아니고 '(' 일때
				// 즉 쇠막대기 시작지점 일때
				if (st2.charAt(i) == '(') {
					stack.push('(');
					temp++;
				}
				// ')' 일때
				// 첫 if에서 ')'를 뛰어 넘었기 때문에
				// 쇠막대기 마지막 지점 일때
				if (st2.charAt(i) == ')') {
					stack.pop();
				}
			}
			bw.write("#" + iter + " " + (ans + temp) + "\n");
		}
		bw.flush();
	}
}