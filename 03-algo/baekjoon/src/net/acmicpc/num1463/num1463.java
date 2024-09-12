package net.acmicpc.num1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1463 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());
		int[] arr = new int[X + 1];
		for (int i = 2; i <= X; i++) {
			int min = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				int tmp = i / 2;
				if (min > arr[tmp]) {
					min = arr[tmp];
				}
			}
			if (i % 3 == 0) {
				int tmp = i / 3;
				if (min > arr[tmp]) {
					min = arr[tmp];
				}
			}
			if (i - 1 >= 1) {
				int tmp = i - 1;
				if (min > arr[tmp]) {
					min = arr[tmp];
				}
			}
			arr[i] = min + 1;
//			System.out.println(Arrays.toString(arr));
		}
		System.out.println(arr[X]);
	}
}