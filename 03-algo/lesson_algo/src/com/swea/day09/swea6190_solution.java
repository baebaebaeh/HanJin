package com.swea.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class swea6190_solution {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input6190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int ans = -1;
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];
					if (ans < num && check(num)) {
						ans = num;
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}
	
	static boolean check(int n) {
		if (n >= 1 && n < 10) {
			return false;
		}
		while (n != 0) {
			int t = n % 10;
			n /= 10;
			if (n % 10 > t) return false;		
		}
		return true;
	}
}