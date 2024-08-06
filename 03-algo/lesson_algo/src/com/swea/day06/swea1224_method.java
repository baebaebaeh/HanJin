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

class swea1224_method {
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('*', 2);
		map.put('/', 2);
		map.put('+', 1);
		map.put('-', 1);
		map.put('(', 0);
	}
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			infixToPostfix(infix);
		}
	}

	private static void infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		for (int i = 0; i < infix.length(); i++) {
			// '(' 일경우 그냥 push
			if (infix.charAt(i) == '(') {
				stack.add('(');
			}
			// ')' 일경우 '('나올때까지 pop 하고 '('도 pop
			else if (infix.charAt(i) == ')') {
				while(stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
			}
			// 숫자일 경우 바로 postfix에 써줌
			else if (infix.charAt(i) >= '0' && infix.charAt(i) <= '9') {
				postfix += infix.charAt(i);
			}
			// 연산자일 경우 top이 우선순위 보다 낮을때 까지 pop 이후 push
			else {
				while (!stack.isEmpty() && map.get(infix.charAt(i)) < map.get(stack.peek())) {
					postfix += stack.pop();
				}
				stack.add(infix.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
	}
}