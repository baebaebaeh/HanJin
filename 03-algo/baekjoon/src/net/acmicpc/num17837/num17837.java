package net.acmicpc.num17837;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num17837 {
	static int N, K;
	static int[][] map;
	static List<List<Queue<Integer>>> 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17837.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = 
			}
		}
		// 0흰 1빨 2파
		// 출력이 1000넘으면 -1
		// 우좌상하
		
	}
}