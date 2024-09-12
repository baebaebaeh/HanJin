package net.acmicpc.num1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1463_ {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());
		int[] arr = new int[X + 1];
		for (int i = 2; i <= X; i++) {
			int tmp1 = Integer.MAX_VALUE;
			int tmp2 = Integer.MAX_VALUE;
			int tmp3 = Integer.MAX_VALUE;
			if (i % 2 == 0) tmp1 = arr[i / 2];
			if (i % 3 == 0) tmp2 = arr[i / 3];
			if (i - 1 >= 1) tmp3 = arr[i - 1];
			int min = Math.min(Math.min(tmp2, tmp3), tmp1);
			arr[i] = min + 1;
//			System.out.println(Arrays.toString(arr));
		}
		System.out.println(arr[X]);
	}
}