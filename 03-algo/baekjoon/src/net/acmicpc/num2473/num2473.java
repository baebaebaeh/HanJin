package net.acmicpc.num2473;

import java.io.*;
import java.util.*;

public class num2473 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input2473.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long L = Long.parseLong(st.nextToken());
			arr[i] = L;
		}
		Arrays.sort(arr);

		long min = Long.MAX_VALUE;
		int leftAns = 0;
		int rightAns = 0;
		int midAns = 0;
		out : for (int i = 1; i < N - 1; i++) {
			int left = 0;
			int right = N - 1;
			while (left != right) {
				long sum = arr[left] + arr[right] + arr[i];
				long absSum = Math.abs(sum);
				if (absSum < min) {
					min = absSum;
					leftAns = left;
					rightAns = right;
					midAns = i;
				}
				if (sum < 0) {
					left++;
					if (left == i) {
						left++;
					}
				} else if (sum > 0) {
					right--;
					if (right == i) {
						right--;
					}
				} else {
					leftAns = left;
					rightAns = right;
					midAns = i;
					break out;
				}
			}
		}
		int[] ans = new int[3];
		ans[0] = leftAns;
		ans[1] = midAns;
		ans[2] = rightAns;
		Arrays.sort(ans);
		for (int i = 0; i < 3; i++) {
			bw.write(arr[ans[i]] + " ");
		}
		bw.flush();
	}
}














