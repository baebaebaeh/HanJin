package net.acmicpc.num14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num14502 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] realmap = new int[N][M];
		List<int[]> list = new LinkedList<>();
		List<int[]> list2 = new LinkedList<>();
		Queue<int[]> queue = new LinkedList<>();
		int realzeroNum = -3;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				realmap[i][j] = Integer.parseInt(st.nextToken());
				if (realmap[i][j] == 2) {
					list2.add(new int[]{i, j});
				}
				if (realmap[i][j] == 0) {
					list.add(new int[] {i, j});
					realzeroNum++;
				}
			}
		}
		int zeroNum = 0;
		int ans = 0;
		int[][] map = new int[N][M];
		int size = list.size();
		int rowIdx;
		int colIdx;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					for (int k2 = 0; k2 < list2.size(); k2++) {
						queue.add(list2.get(k2));						
					}
					zeroNum = realzeroNum;
					for (int row = 0; row < N; row++) {
						for (int col = 0; col < M; col++) {
							map[row][col] = realmap[row][col];
						}
					}
					map[list.get(i)[0]][list.get(i)[1]] = 1;
					map[list.get(j)[0]][list.get(j)[1]] = 1;
					map[list.get(k)[0]][list.get(k)[1]] = 1;
					int[] idx;
					while (!queue.isEmpty()) {
						idx = queue.poll();
						for (int d = 0; d < 4; d++) {
							rowIdx = idx[0] + dr[d];
							colIdx = idx[1] + dc[d];
							if (rowIdx >= 0 && rowIdx < N &&
									colIdx >= 0 && colIdx < M &&
									map[rowIdx][colIdx] == 0) {
								queue.add(new int[] {rowIdx, colIdx});
								map[rowIdx][colIdx] = 2;
								zeroNum--;
							}
						}
					}
					if (ans < zeroNum) ans = zeroNum;
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
	}
}