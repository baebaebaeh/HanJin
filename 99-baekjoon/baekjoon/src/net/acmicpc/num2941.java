package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		String code = st1.nextToken();
		int N = code.length();
		int M = code.length();
		for (int i = 0; i < N; i++) {
			if (code.charAt(i) == '=') {
				M -= 1;
				if (i > 1 && code.charAt(i - 2) == 'd' && code.charAt(i - 1) == 'z') {
					M -= 1;
				}
			}
			if (code.charAt(i) == '-')
				M -= 1;
			if (i > 0 && code.charAt(i) == 'j' && (code.charAt(i - 1) == 'l' || code.charAt(i - 1) == 'n')) {
				M -= 1;
			}

		}
		bw.write(Integer.toString(M));
		bw.flush();
	}
}
