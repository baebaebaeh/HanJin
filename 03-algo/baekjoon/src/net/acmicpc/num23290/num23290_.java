package net.acmicpc.num23290;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num23290_ {
	static List<List<Queue<Integer>>> map; // 얘는 그냥 상어가 최다 물고기 경로 찾는 용도
	static List<List<Queue<Integer>>> copyMap;
	static Queue<int[]> tmpQueue;
	static int[][] countMap;
	static int[][] smell; // 0이 아니면 스멜~
	static List<int[]> moveList;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dsr = { -1, 0, 1, 0 };
	static int[] dsc = { 0, -1, 0, 1 };
	static int tmpX, tmpY, maxFish;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input23290.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		countMap = new int[4][4];
		map = new ArrayList<>();
		tmpQueue = new ArrayDeque<>();
		for (int i = 0; i < 4; i++) {
			map.add(new ArrayList<>());
			for (int j = 0; j < 4; j++) {
				map.get(i).add(new ArrayDeque<>());
			}
		}
		smell = new int[4][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken()) - 1;
			int fy = Integer.parseInt(st.nextToken()) - 1;
			// 좌 좌상 상 우상 우 우하 하 좌하
			// 1 2 3 4 5 6 7 8
			int d = Integer.parseInt(st.nextToken()) - 1;
			map.get(fx).get(fy).add(d);
			countMap[fx][fy]++;
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;
		if (countMap[sx][sy] != 0) {
			int tmp = map.get(sx).get(sy).size();
			for (int i = 0; i < tmp; i++) {
				map.get(sx).get(sy).poll();
			}
			countMap[sx][sy] = 0;
		}
		
		for (int i = 0; i < S; i++) {
			
		moveFish(sx, sy);
		moveShark(sx, sy);
		sharkEat();
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				if (smell[i][j] == 0) {
//					continue;
//				}
//				smell[i][j]--;
//			}
//		}
//		for (int i = 0; i < tmpList.size(); i++) {
//			for (int j = 0; j < 2; j++) {
//			 	System.out.print(tmpList.get(i)[j] +" "); 
//			}
//			System.out.println();
//		}
		
		
		
		
		
//		for (int[] a : smell)
//			System.out.println(Arrays.toString(a));
		for (int[] a : countMap)
			System.out.println(Arrays.toString(a));
		System.out.println();
		
		
		}
		
		
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				for (int j2 = 0; j2 < map.get(i).get(j).size(); j2++) {
//					System.out.println(map.get(i).get(j).poll());
//				}
//			}
//		}
	}

	private static void sharkEat() {
		for (int i = 0; i < 3; i++) {
			moveList.get(i);
		}
	}

	private static void moveShark(int sx, int sy) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { sx, sy });
		dfs(list, 0, 0);
	}

	private static void dfs(List<int[]> list1, int dist, int fish) {
		if (dist == 3) {
			if (fish >= maxFish) {
				moveList = list1;
			}
			return;
		}
		for (int d = 3; d >= 0; d--) {
			int nsx = list1.get(dist)[0] + dsc[d];
			int nsy = list1.get(dist)[1] + dsr[d];
			if (nsx >= 0 && nsx < 4 && nsy >= 0 && nsy < 4) {
				list1.add(new int [] { list1.get(dist)[0] + dsc[d], list1.get(dist)[1] + dsr[d] });
				dfs(list1, dist + 1, fish + countMap[nsx][nsy]);				
			}
		}
	}

	private static void moveFish(int sx, int sy) {
		// 모든 4*4에서
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				// 해당 위치에서 모든 물고기에 만큼 돌림
				int tmp = map.get(r).get(c).size();
				out : for (int i = 0; i < tmp; i++) {
					// 물고기 하나 뽑아서 (그냥 물고기 방향임)
					int d = map.get(r).get(c).poll();
					// 8번 돌려
					for (int j = 0; j < 8; j++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && // 벗어나지않고
								smell[nr][nc] == 0 && // 냄새나지 않고
								(nr != sx || nc != sy)) { // 상어가 아니면
							countMap[r][c]--; // 물고기 위치 --
							countMap[nr][nc]++; // 물고기 이동할곳 ++
							tmpQueue.add(new int[] {nr, nc, d}); // 물고기 추가
							continue out;
						}
						d--;
						if (d == -1) {
							d += 8;
						}
					} // 8번 돌때까지 별 문제 없었으면 그냥 안움직이고 넘어감
					tmpQueue.add(new int[] {r, c, d}); // 물고기 추가
				}
			}
		}
		while (!tmpQueue.isEmpty()) {
			int[] fish = tmpQueue.poll();
			map.get(fish[0]).get(fish[1]).add(fish[2]);
		}
	}
}