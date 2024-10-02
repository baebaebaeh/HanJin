package net.acmicpc.num123123123;

import java.io.*;
import java.util.*;

public class num123123123 {
	static int N, M, ans;
	static int[] counting, preidx, nowidx;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input2343.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		counting = new int[N + 1];
		counting[0] = 0;

		preidx = new int[M + 1];
		nowidx = new int[M + 1];

		nowidx[M] = N;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			counting[i] = Integer.parseInt(st.nextToken()) + counting[i - 1];
		}
		for (int i = 1; i < M; i++) {
			nowidx[i] = i;
		}
//		System.out.println(Arrays.toString(preidx));
//		System.out.println(Arrays.toString(nowidx));
		out: while (true) {
			for (int i = 0; i <= M; i++) {
				preidx[i] = nowidx[i];
			}
			for (int i = M - 1; i >= 1; i--) {
				int tmp = search(i);
				nowidx[i] = tmp;
//				System.out.print(i + " ");
//				System.out.println(tmp);
			}
			for (int i = 1; i < M; i++) {
				if (nowidx[i] != preidx[i]) {
					continue out;
				}
			}
			break;
		}
//		System.out.println(Arrays.toString(counting));
//		System.out.println(Arrays.toString(nowidx));
		for (int i = 1; i < M; i++) {
			int sum = counting[nowidx[i]] - counting[nowidx[i - 1]];
//			System.out.println(sum);
			if (sum > ans) {
				ans = sum;
			}
		}
		System.out.println(ans);
	}

	private static int search(int idx) {
        int left = nowidx[idx - 1];
        int right = nowidx[idx + 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int leftSum = counting[mid] - counting[nowidx[idx - 1]];
            int rightSum = counting[nowidx[idx + 1]] - counting[mid + 1];
            if (leftSum > rightSum) {
                right = mid;
            } else {
                left = mid + 1; // mid를 포함하도록 변경
            }
        }
        return left;
	}
}
