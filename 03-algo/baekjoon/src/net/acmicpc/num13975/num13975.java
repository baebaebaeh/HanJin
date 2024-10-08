package net.acmicpc.num13975;
import java.io.*;
import java.util.*;

public class num13975 {
	static PriorityQueue<Long> pq;
	static long sum;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input11066.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			sum = 0;
			int K = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>((o1, o2) -> {
				return (int) (o1 - o2);
			});
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				long L = Long.parseLong(st.nextToken());
				pq.add(L);
			}
			while (pq.size() != 1) {
				long next = pq.poll() + pq.poll();
				sum += next;
				pq.add(next);
			}
			System.out.println(sum);
		}
	}
}