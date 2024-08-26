package net.acmicpc.num14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num14503_ {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		List<int[]> list1 = new LinkedList<>();
		List<int[]> list2 = new LinkedList<>();
		Queue<int[]> queue = new LinkedList<>();
		int realzeroNum = -3;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list2.add(new int[] { i, j });
				}
				if (map[i][j] == 0) {
					list1.add(new int[] { i, j });
					realzeroNum++;
				}
			}
		}
		int zeroNum = 0;
		int ans = 0;
		boolean[][] visited = new boolean[N][M];
		int size = list1.size();
		int rowIdx;
		int colIdx;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					zeroNum = realzeroNum;
					map[list1.get(i)[0]][list1.get(i)[1]] = 1;
					map[list1.get(j)[0]][list1.get(j)[1]] = 1;
					map[list1.get(k)[0]][list1.get(k)[1]] = 1;
					for (int k2 = 0; k2 < list2.size(); k2++) {
						queue.add(list2.get(k2));
					}
					int[] idx;
					while (!queue.isEmpty()) {
						idx = queue.poll();
						for (int d = 0; d < 4; d++) {
							rowIdx = idx[0] + dr[d];
							colIdx = idx[1] + dc[d];
							if (rowIdx >= 0 && rowIdx < N && 
									colIdx >= 0 && colIdx < M && 
									map[rowIdx][colIdx] == 0 &&
									visited[rowIdx][colIdx] == false) {
								queue.add(new int[] { rowIdx, colIdx });
								zeroNum--;
								visited[rowIdx][colIdx] = true;
							}
						}
					}
					if (ans < zeroNum)
						ans = zeroNum;
					for (int l = 0; l < N; l++) {
						Arrays.fill(visited[l], false);
					}
					map[list1.get(i)[0]][list1.get(i)[1]] = 0;
					map[list1.get(j)[0]][list1.get(j)[1]] = 0;
					map[list1.get(k)[0]][list1.get(k)[1]] = 0;
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
	}
}