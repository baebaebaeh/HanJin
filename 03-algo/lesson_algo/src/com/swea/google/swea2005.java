package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class swea2005 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input2005.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			bw.write("#" + iter + "\n");
			int[] arr = new int[10];
			arr[0] = 1;
			// 무조건 1은 출력
			bw.write("1 \n");
			int N = Integer.parseInt(br.readLine());
			// 2번째 줄부터 출력이니 N - 2번 반복
			for (int i = 0; i < N - 1; i++) { // 1번for문
				// 파스칼 배열 만들어줌
				for (int j = 9; j > 0; j--) {
					arr[j] += arr[j - 1];
				}
				// 1번 for문의 첫번째 스탭일때 arr을 두개 출력하고 싶다.
				for (int j = 0; j < i + 2; j++) {
					bw.write(arr[j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}