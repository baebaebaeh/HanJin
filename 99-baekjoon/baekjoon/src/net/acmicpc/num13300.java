package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num13300 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input13300.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] girl = new int[6];
		int[] boy = new int[6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0)
				girl[Integer.parseInt(st.nextToken()) - 1] += 1;
			else
				boy[Integer.parseInt(st.nextToken()) - 1] += 1;
		}
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += girl[i] / K;
			if (girl[i] % K != 0) {
				sum += 1;
			}
			sum += boy[i] / K;
			if (boy[i] % K != 0) {
				sum += 1;
			}
		}
		bw.write(sum + "");
		bw.flush();
	}
}