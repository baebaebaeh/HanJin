package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num17413_test {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17413.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		int temp = 0; // 문자열 뒤집기 시작하는 인덱스
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '<') { // 1-1. '<' 나오면
				if (i > 0) {  // 3-1. 첫 글자로 '<' 나 ' '가 나오면 그 전에 문자가 못 오기 때문에
					for (int j = i - 1; j >= temp; j--) {  // 3-2. '<'가 나오기 하나 전부터 temp까지 써준다 (거꾸로 씀)
						bw.write(S.charAt(j));
					}
				}
				while (S.charAt(i) != '>') { // 1-2. '>' 나오기 전까지 
					bw.write(S.charAt(i)); // 1-3. 차례로 쓰고
					i++;
				}
				bw.write('>'); // 1-4. '>' 쓴다.
				temp = i + 1;  // 1-5. '>' 다음 인덱스로 바꿔줌
				continue;
			}
			if (S.charAt(i) == ' ') { // 2-1. ' ' 나오면
				if (i > 0) { // 3-1. 첫 글자로 '<' 나 ' '가 나오면 그 전에 문자가 못 오기 때문에
					for (int j = i - 1; j >= temp; j--) { // 3-2. ' '가 나오기 하나 전부터 temp까지 써준다 (거꾸로 씀)
						bw.write(S.charAt(j));
					}
				}
				bw.write(' '); // 2-2. ' ' 쓰고
				temp = i + 1; // 2-3. ' ' 다음 인덱스로 바꿔줌
				continue;
			}
			if (i > 0 && i == S.length() - 1) { // 마지막 문자 검사할때 '<'와 ' '이 아닐때
				for (int j = i; j >= temp; j--) {
					bw.write(S.charAt(j)); // 마지막 문자에서 temp까지 써줌
				}
			}
		}
		bw.flush();
	}
}