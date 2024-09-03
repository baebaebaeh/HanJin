package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class num11399 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input11399.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// 카운팅정렬 사용해서 풀어보자
		int[] arr = new int[N];
		int[] sortArr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[1001];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}
		for (int i = 0; i < count.length - 1; i++) {
			count[i + 1] += count[i];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			sortArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < N - 1; i++) {
			sortArr[i + 1] += sortArr[i];
		}
		int sum = 0;
		for (int a : sortArr) {
			sum += a;
		}
		bw.write(sum + "");
		bw.flush();
	}
}