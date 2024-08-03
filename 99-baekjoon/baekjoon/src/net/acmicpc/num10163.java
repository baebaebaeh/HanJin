package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num10163 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input10163.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[1001][1001];
		int[] area = new int[L+1];
		for (int iter = 1; iter <= L; iter++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int colLen = Integer.parseInt(st.nextToken());
			int rowLen = Integer.parseInt(st.nextToken());
			for (int i = row; i < row + rowLen; i++) {
				for (int j = col; j < col + colLen; j++) {
					map[i][j] = iter;
				}
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				area[map[i][j]]++;
			}
		}
		for (int i = 1; i <= L; i++) {
			bw.write(area[i] + "\n");
		}
		bw.flush();
	}
}