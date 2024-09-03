package net.acmicpc.num19236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int num;
	int dir;

	public void setDir(int dir) {
		this.dir = dir;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "num=" + num + ", dir=" + dir;
	}

}

public class num {
	static Node[][] node;
	static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int sr = 0;
	static int sc = 0;
	static int max = 0;
	static int tempmax = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input19236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		node = new Node[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				node[i][j] = new Node();
			}
		}
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int tempnum = Integer.parseInt(st.nextToken());
				int tempdir = Integer.parseInt(st.nextToken());
				node[i][j].setDir(tempdir);
				node[i][j].setNum(tempnum);
			}
		}
		int[] initial = { 0, 0 };
		eat(initial, node);
		System.out.println(max);
	}

	static void eat(int[] a, Node[][] node) {
		tempmax = 0;
		Node[][] newNode = node;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (newNode[i][j].num == 17)
					newNode[i][j].setNum(0);
			}
		}
		int r = a[0];
		int c = a[1];
		tempmax += newNode[r][c].num;
		newNode[r][c].setNum(17);
		List<int[]> list = new ArrayList<>();
		newNode = change(newNode);
		int d = 0;
		d = newNode[r][c].dir;
		while (r + dr[d] >= 0 && r + dr[d] < 4 && c + dc[d] >= 0 && c + dc[d] < 4) {
			if (newNode[r + dr[d]][c + dc[c]].num == 0)
				continue;
			int[] arr = { r + dr[d], c + dc[d] };
			list.add(arr);
			r += dr[d];
			c += dc[d];
		}
		for (int j = 0; j < list.size(); j++) {
			eat(list.get(j), newNode);
			if (max < tempmax) {
				max = tempmax;
			}
		}
	}

	static Node[][] change(Node[][] node) {
		out1 : for (int num = 1; num <= 16; num++) {
			int r = 100;
			int c = 100;
			out: for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (node[i][j].num == num) {
						r = i;
						c = j;
						break out;
					}
				}
			}
			if (r == 100) continue out1;
			int d = node[r][c].dir;

			while (r + dr[d] < 0 || r + dr[d] >= 4 || c + dc[d] < 0 || c + dc[d] >= 4
					|| node[r + dr[d]][c + dc[d]].num == 17) {
				d++;
				d %= 9;
				if (d == 0)
					d++;
			}

			Node tempN = new Node();
			tempN = node[r][c];
			node[r][c] = node[r + dr[d]][c + dc[d]];
			node[r + dr[d]][c + dc[d]] = tempN;
		}
		return node;
	}
}
