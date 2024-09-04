package com.ssafy.offline;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	
	static int[] parents;
	static int V, E;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input크루스칼.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		parents = new int[V];
		
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		int sum = 0;
		for (Edge e : edgeList) {
			if (!union(find(e.from), find(e.to))) continue;
			sum += e.weight;
			if (++cnt == V - 1) {
				break;
			}
		}
		System.out.println(sum);
	}
	
	public static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int aRoot, int bRoot) {
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}
