package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num8320 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st1.nextToken());
		int max = (int) Math.sqrt(L); // 루트씌우고 나머지 버림
		int sum = 0;
		for (int i = max; i > 0; i--) {
			sum += ((L / i) - i + 1);
		}
		bw.write(Integer.toString(sum)); // 프린트
		bw.flush();
	}
}