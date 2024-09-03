package net.acmicpc.num1446;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1466 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = 0;
		int N = Integer.parseInt(st.nextToken()); // 고속도로 시작점
		int end = Integer.parseInt(st.nextToken()); // 고속도로 끝점
		// 각각의 노드에 
		for (int i = 0; i <= end; i++) {
			graph.add(new ArrayList<Node>());
		}
		dist = new int[end + 1];
		for (int i = 0; i < end + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 지름길의 start 인덱스
			int e = Integer.parseInt(st.nextToken()); // 지름길의 end 인덱스
			int c = Integer.parseInt(st.nextToken()); // 지름길의 cost 값
			// 값 받을때 
			if (e > end || s > end) {
				continue;
			}
			graph.get(s).add(new Node(e, c));
		}
		for (int i = 0; i <= end; i++) {
			graph.get(i).add(new Node(i + 1, 1));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		dist[start] = 0;
		pq.add(new Node(start, dist[start]));
		while (!pq.isEmpty()) {
			Node nowNode = pq.poll();
			if (nowNode.idx == end) {
				System.out.println(nowNode.cost);
				break;
			}
			if (dist[nowNode.idx] < nowNode.cost) {
				continue;
			}
			for (int i = 0; i < graph.get(nowNode.idx).size(); i++) {
				Node nextNode = graph.get(nowNode.idx).get(i);
				if (dist[nextNode.idx] > nowNode.cost + nextNode.cost) {
					dist[nextNode.idx] = nowNode.cost + nextNode.cost;
					pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
	}
}

class Node {
	int idx;
	int cost;
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}
