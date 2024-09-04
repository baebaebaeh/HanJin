package net.acmicpc.num1446;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num1446 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = 0;
		int N = Integer.parseInt(st.nextToken()); // 고속도로의 시작
		int end = Integer.parseInt(st.nextToken()); // 고속도로의 끝
		// 미터마다 다음 노드를 가리키는 배열을 넣어줌 (인덱스가 미터)
		for (int i = 0; i <= end; i++) {
			graph.add(new ArrayList<Node>());
		}
		dist = new int[end + 1];
		for (int i = 0; i < end + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 간선의 시작
			int e = Integer.parseInt(st.nextToken()); // 간선의 끝
			int c = Integer.parseInt(st.nextToken()); // 간선의 코스트
			if (e > end || s > end) { // 고속도로 벗어나면 안받음
				continue;
			}
			// 고속도로 안벗어나면 받아줌
			graph.get(s).add(new Node(e, c));
		}
		// 각 미터마다 미터+1 을 추가해줌
		for (int i = 0; i <= end; i++) {
			graph.get(i).add(new Node(i + 1, 1));
		}
		// 코스트가 낮은 순으로 정렬하는 queue
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		dist[start] = 0;
		pq.add(new Node(start, dist[start]));
		while (!pq.isEmpty()) {
			Node nowNode = pq.poll(); // 나우 노드로 받아주고
			// priority queue사용했으니까 고속도로 도착했을때 cost가 가장 적은 cost니
			// while 부수고 나와
			if (nowNode.idx == end) { 
				System.out.println(nowNode.cost);
				break;
			}
			// 코스트가 더 비싸지면 queue에 추가하지 말고 넘어가
			if (dist[nowNode.idx] < nowNode.cost) {
				continue;
			}
			// graph.get(i) -> 다음노드들
			for (int i = 0; i < graph.get(nowNode.idx).size(); i++) {
				// 다음 노드들 만큼 돌리고 해당 노드를 받아서
				Node nextNode = graph.get(nowNode.idx).get(i);
				// 현재 코스트와 다음 노드로 갈때의 코스트를 더했을때
				if (dist[nextNode.idx] > nowNode.cost + nextNode.cost) {
					// 적으면 업데이트 해준다.
					dist[nextNode.idx] = nowNode.cost + nextNode.cost;
					// 업데이트 해주고 현재 노드의 다음 노드를 queue에 넣어줌
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
