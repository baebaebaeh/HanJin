package com.swea.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class ImTest4 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int ans = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W1 = Integer.parseInt(st.nextToken());
			int W2 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken())); 
			}
			int min = Math.min(W1, W2);
			int max = Math.max(W1, W2);
			for (int i = max; i > min; i--) {
				ans += pq.poll() * i;
			}
			for (int i = min; i > 0; i--) {
				ans += pq.poll() * i;
				ans += pq.poll() * i;
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}