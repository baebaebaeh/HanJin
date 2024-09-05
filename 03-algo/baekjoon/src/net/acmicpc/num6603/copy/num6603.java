package net.acmicpc.num6603.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num6603 {
	static int[] arr;
	static int N;
	static int R = 6;
	static int[] sel = new int [R];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		out : while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			if (L != 0) {
				arr = new int[L];
				N = arr.length;
				for (int i = 0; i < L; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				comb(0, 0);
				System.out.println();
			} else {
				break out;
			}			
		}
	}
	
	private static void comb(int start, int startIdx) {
		if (startIdx == R) {
			for (int i = 0; i < 6; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N - R + startIdx; i++) {
			sel[startIdx] = arr[i];
			comb(i + 1, startIdx + 1);
		}
	}
}

