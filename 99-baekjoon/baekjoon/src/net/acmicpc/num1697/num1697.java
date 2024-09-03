package net.acmicpc.num1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class num1697 {
	static int ans = 0;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("data/input1697.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { N, 0 });
		visited[N] = true;
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int posi = arr[0];
			int time = arr[1];
			if (posi == K) {
				ans = time;
				break;
			}
			if (posi + 1 <= 100000 && !visited[posi + 1]) {
				q.add(new int[] { posi + 1, time + 1 });
				visited[posi + 1] = true;
			}
			if (posi * 2 <= 100000 && !visited[posi * 2]) {
				q.add(new int[] { posi * 2, time + 1 });
				visited[posi * 2] = true;
			}
			if (posi - 1 >= 0 && !visited[posi - 1]) {
				q.add(new int[] { posi - 1, time + 1 });
				visited[posi - 1] = true;
			}
		}
		System.out.println(ans);
	}
}
