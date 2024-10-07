package net.acmicpc.num2470;

import java.io.*;
import java.util.*;

public class num2470_ {
	static long[] arr;
	static long tmpMin, tmp;
	static int N;
	static int[] min;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input2470.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		min = new int [2];
		min[1] = N - 1;
		for (int i = 0; i < N - 1; i++) {
			binarySearch(i);
		}
		bw.write(arr[min[0]] + " " + arr[min[1]]);
		bw.flush();
	}

	private static void binarySearch(int startIdx) {
		int left = startIdx + 1;
		int right = N - 1;
		int mid = 0;
		tmpMin = Math.abs(arr[startIdx] + arr[right]);
		while (left < right) {
			mid = (right + left) / 2;
			tmp = Math.abs(arr[startIdx] + arr[mid]);
			if (arr[mid] < 0) {
				left = mid + 1;
				continue;
			}
			if (arr[startIdx] >= 0) {
				right = mid;
				continue;
			}
			if (arr[startIdx] + arr[mid] > 0) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if (Math.abs(arr[min[0]] + arr[min[1]]) > Math.abs(arr[startIdx] + arr[left])) {
			min[0] = startIdx;
			min[1] = left;
		}
	}
}