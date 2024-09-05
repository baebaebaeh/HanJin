package com.swea.num1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num1251 {
	static double[] xArr;
	static double[] yArr;
	static Edge[] edges;
	static int[] parents;
	static int N;
	static double E, ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1251_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			N = Integer.parseInt(br.readLine());
			xArr = new double[N];
			yArr = new double[N];
			parents = new int[N];
			edges = new Edge[N * (N - 1) / 2];
			ans = 0;
			make();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xArr[i] = Double.parseDouble(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yArr[i] = Double.parseDouble(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			int temp = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double xleng = xArr[i] - xArr[j];
					double yleng = yArr[i] - yArr[j];
					double leng = xleng * xleng + yleng * yleng; 
					edges[temp++] = new Edge(i, j, E * leng);
				}
			}
			Arrays.sort(edges);
			System.out.println(Arrays.toString(edges));
			int tmp = 0;
			for (int i = 0; i < N * (N - 1) / 2; i++) {
				int x = find(edges[i].from) ;
				int y = find(edges[i].to) ;   
				if (x != y) {
					ans += edges[i].weight;
					union(x, y);
					tmp++;
				}
				if (tmp == N + 1) break;
			}
			if ((ans * 10) % 10 >= 5) ans += 1;
			
			System.out.println("#" + iter + " " + (long)ans);
		}
	}
	static void union(int x, int y) {
		if (x == y) {
			return;
		}
		parents[y] = x; 
	}
	
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find((int) parents[x]);
	}
}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	double weight;
	
	@Override
	public String toString() {
		return "Edge [i=" + from + ", j=" + to + ", weight=" + weight + "]";
	}

	public Edge(int i, int j, double weight) {
		super();
		this.from = i;
		this.to = j;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return (int) ((this.weight - o.weight) * 10);
	}
	
}