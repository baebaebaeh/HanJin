package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class num17413 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17413.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Character> ans = new ArrayList<>();
		String S = br.readLine();
		int temp = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '<') {
				if (i > 0) {
					for (int j = i - 1; j >= temp; j--) {
						ans.add(S.charAt(j));
					}
				}
				while (S.charAt(i) != '>') {
					ans.add(S.charAt(i));
					i++;
				}
				ans.add('>');
				temp = i + 1;
				continue;
			}
			if (S.charAt(i) == ' ') {
				if (i > 0) {
					for (int j = i - 1; j >= temp; j--) {
						ans.add(S.charAt(j));
					}
				}
				ans.add(' ');
				temp = i + 1;
				continue;
			}
			if (i > 0 && i == S.length() - 1) {
				for (int j = i; j >= temp; j--) {
					ans.add(S.charAt(j));
				}
			}
		}
		for (Character a : ans) {
			System.out.print(a);
		}
	}
}