package com.swea.google;

/*
 * 문제 : SWEA5432 쇠막대기 자르기
 * 메모리 : 29,976kb
 * 실행시간 : 171ms
 * 코드길이 : 1,899
 * 설명 : 레이저가 나오면 겹쳐있는 쇠막대기 만큼 추가로 생긴다.
 * 레이저로인해 추가로 생긴 쇠막대기 + 기존 쇠막대기 = 최종 쇠막대기 개수
 * '(' 이후 바로 ')'가 나오는 경우에 레이저라고 생각한다. 
 * 레이저가 아닐때 '('를 쇠막대기 시작으로 생각해서 stack에 push.
 * 레이저가 아닐때 ')'를 쇠막대기 끝으로 생각해서 stack에 pop.
 * 레이저가 나올때 stack의 길이를 계속 더해준다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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