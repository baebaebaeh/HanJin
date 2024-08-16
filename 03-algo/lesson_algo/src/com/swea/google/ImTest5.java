package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ImTest5 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		out : for (int iter = 1; iter <= T; iter++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			int count = 1;
			int prev = pq.poll();
			int now = 0;
			for (int i = 1; i < N; i++) {
				now = pq.poll();
				if (prev != now) {
					list.add(count);
					count = 1;
				}
				if (prev == now) {
					count++;
				}
				prev = now;
			}
			list.add(count);
			int length = list.size();
			int sumI = 0; // 부진
			int sumJ = 0; // 보통
			int sumK = 0; // 우수
			int ans = 10000000; // 최솟값
			for (int i = 0; i < length - 2; i++) {
				sumI += list.get(i);
				for (int j = i + 1; j < length - 1; j++) {
					sumJ += list.get(j);
					for (int k = j + 1; k < length; k++) {
						sumK += list.get(k);
					}
					if (min <= sumK && sumK <=max &&
							min <= sumJ && sumJ <=max &&
							min <= sumI && sumI <=max) {
						int tempMax = Math.max(Math.max(sumI, sumJ), sumK);
						int tempMin = Math.min(Math.min(sumI, sumJ), sumK);
						if (ans > (tempMax - tempMin)) ans = tempMax - tempMin;
					}
					sumK = 0;
				}
				sumJ = 0;
			}
			if (ans == 10000000) {
				bw.write("#" + iter + " " + -1 + "\n");
				continue out;
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}