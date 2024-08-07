package com.swea.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea1225 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter <= 10; iter++) {
			bw.write("#" + iter + " ");
			br.readLine();
			int[] arr = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int num = 1;
			int i = 0;
			while (arr[i] - num > 0) {
				arr[i] -= num;
				num++;
				if (num == 6) num = 1;
				i++;
				i = i % 8;
			}
			arr[i] = 0;
			for (int j = 0; j < 8; j++) {
				i++;
				i = i % 8;
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}