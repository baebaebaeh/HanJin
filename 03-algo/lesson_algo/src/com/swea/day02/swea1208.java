package com.swea.day02;
/*
문제 : SWEA-1208-Flatten
메모리 : 21676 kb
시간 : 135 ms
코드길이 : 1035
설명 : 높이 배열 만들고 오름차순 정렬
양끝이 같아지면 빠져나오는 구문
왼쪽은 - 오른쪽은 + 해준다.
이후 한번더 정렬해주고 출력
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class swea1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 0; iter < 10; iter++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int dump = Integer.parseInt(st1.nextToken());
			int[] hight = new int[100];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				hight [i] = Integer.parseInt(st2.nextToken());
			}
			for (int i = 0; i < dump; i++) {
				Arrays.sort(hight);
				if (hight[0] - hight[99] <= 1) break;
				hight[0]++;
				hight[99]--;
			}
			Arrays.sort(hight);
			bw.write("#" + (iter +1) + " " + (hight[99] - hight[0]) + "\n");
		}
		bw.flush();
	}
}