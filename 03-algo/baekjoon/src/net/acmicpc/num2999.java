package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		String code = st1.nextToken();
		int N = code.length();
		int R = 0;
		System.out.println(Math.sqrt(N));
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0)
				R = i;
		}
		int C = N / R;
		char[][] map = new char[R][C];
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				map[i][j] = code.charAt(R*j+i);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(map[i][j]);
			}
		}
		bw.flush();
	}
}
