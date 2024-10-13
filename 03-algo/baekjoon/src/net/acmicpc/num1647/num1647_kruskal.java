package net.acmicpc.num1647;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;
	public Edge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}
}

public class num1647_kruskal {
	static PriorityQueue<Edge> edges;
	static int[] p;
	static int N, M, sum, max;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1647.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집의개수 (2 ~ 100,000)
		M = Integer.parseInt(st.nextToken()); // 길의개수 (1 ~ 1,000,000)
		edges = new PriorityQueue<Edge>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		p = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			Edge edge = new Edge(s, e, w);
			edges.add(edge);
		}
		// 입력받기 끝
		make();
		int pick = 0;
		sum = 0;
		max = 0;
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();			
			int s = edge.start;
			int e = edge.end;
			int w = edge.weight;
			if (!union(s, e)) continue;
			pick++;
			sum += w;
			if (w > max) max = w;
			if (pick == N-1) {
				break;
			}
		}
		System.out.println(sum - max);
		
	}
	static void make() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if (ap == bp) {
			return false;
		}
		p[ap] = bp;
		return true;
	}
}











