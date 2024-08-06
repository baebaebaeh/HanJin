package com.swea.day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class swea1224 {

	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
	}

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			br.readLine();
			String N = br.readLine();
			Stack<Character> stack = new Stack<>();
			String postfix = "";
			for (int i = 0; i < N.length(); i++) {
				// 숫자 나오면 그냥 출력
				if (N.charAt(i) >= '0' && N.charAt(i) <= '9') {
					postfix += N.charAt(i) - '0';
				}
				// ')' 나오면 '('나올때까지 pop
				else if (N.charAt(i) == ')') {
					while (stack.peek() != '(') {
						postfix += stack.pop();
					}
					stack.pop();
				}
				// '(' 나오면 push
				else if (N.charAt(i) == '(') {
					stack.push(N.charAt(i));
				}
				// 연산자 나오면 우선순위 낮은게 나올때까지 pop
				else {
					while (!stack.isEmpty() && 
							map.get(stack.peek()) > map.get(N.charAt(i))) {
						postfix += stack.pop();
					}
					stack.push(N.charAt(i)); 
				}
			}
			while (!stack.isEmpty())
				postfix += stack.pop();
			
			Stack<Integer> stack2 = new Stack<>();
			for (int j = 0; j < postfix.length(); j++) {
				if (postfix.charAt(j) >= '0' && postfix.charAt(j) <= '9') {
					stack2.add(postfix.charAt(j) - '0');
				} else {
					int num2 = stack2.pop();
					int num1 = stack2.pop();
					if (postfix.charAt(j) == '*') stack2.add(num1 * num2);
					if (postfix.charAt(j) == '/') stack2.add(num1 / num2);
					if (postfix.charAt(j) == '+') stack2.add(num1 + num2);
					if (postfix.charAt(j) == '-') stack2.add(num1 - num2);
				}
			}
			
			bw.write("#" + iter + " " + stack2.pop() + "\n");
		}
		bw.flush();
	}
}