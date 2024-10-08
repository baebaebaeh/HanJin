package net.acmicpc.num13424;

import java.io.*;
import java.util.*;

public class num13424 {
	static List<List<Node>> list;
	static boolean[] visited;
	static int[] sum;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input13424.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 노드개수
			N = Integer.parseInt(st.nextToken());
			// 간선개수
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			list = new ArrayList<>();
			sum = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				list.add(new ArrayList<Node>());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				Node node1 = new Node(second, w);
				list.get(first).add(node1);
				Node node2 = new Node(first, w);
				list.get(second).add(node2);
			}
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] friend = new int[K];
			for (int i = 0; i < K; i++) {
				friend[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				int f = friend[i];
				dijkstra(f);
				Arrays.fill(visited, false);
			}
			int a = Integer.MAX_VALUE;
			int ans = 0;
			for (int i = 1; i < N + 1; i++) {
				if (sum[i] < a) {
					a = sum[i];
					ans = i;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}

	static void dijkstra(int startIdx) {
		int[] tmpSum = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			tmpSum[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});
		for (int i = 0; i < list.get(startIdx).size(); i++) {
			int next = list.get(startIdx).get(i).next;
			int w = list.get(startIdx).get(i).weight;
			pq.add(new int[] { next, w });
			tmpSum[next] = w;
		}
		visited[startIdx] = true;
		tmpSum[startIdx] = 0;
		
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int n = now[0];
			int w = now[1];
			for (int i = 0; i < list.get(n).size(); i++) {
				int next = list.get(n).get(i).next;
				int weight = list.get(n).get(i).weight + w;
				if (!visited[next] && weight < tmpSum[next]) {
					pq.add(new int[] {next, weight});
					tmpSum[next] = weight;
				}
			}
		}
		
		for (int i = 0; i < N + 1; i++) {
			if (tmpSum[i] == Integer.MAX_VALUE) continue;
			sum[i] += tmpSum[i];
		}
	}
}

class Node {
	int next;
	int weight;

	public Node() {
	}

	public Node(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}

}