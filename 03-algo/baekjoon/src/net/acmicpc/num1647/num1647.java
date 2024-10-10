package net.acmicpc.num1647;

import java.io.*;
import java.util.*;
class Node {
	int next;
	int weight;
	public Node(int next, int weight) {
		next = this.next;
		weight = this.weight;
	}
	public Node() {}
}
public class num1647 {
	static int[] edge;
	static List<List<Node>> list;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1647.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의개수 (2 ~ 100,000)
		int M = Integer.parseInt(st.nextToken()); // 길의개수 (1 ~ 1,000,000)
		edge = new int[N];
		for (int i = 0; i < N; i++) {
			edge[i] = Integer.MAX_VALUE;
		}
		edge[0] = 0;
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {			
			list.add(new ArrayList<Node>());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			Node node1 = new Node(e, w);
			list.get(s).add(node1);
			Node node2 = new Node(s, w);
			list.get(e).add(node2);
		}
		// 입력받기 끝
		// list.get(집에서).get(번째).next 다음
		for (int i = 0; i < N - 1; i++) {
		int minIdx = 0;
		int tmpMin = Integer.MAX_VALUE;
			
		}
	}
}



















