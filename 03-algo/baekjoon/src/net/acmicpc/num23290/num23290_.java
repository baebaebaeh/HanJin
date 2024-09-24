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
	static int[] dsr = { 0, 1, 0, -1 };
	static int[] dsc = { 1, 0, -1, 0 };
	static int tmpX, tmpY, maxFish, sx, sy, ans;

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
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
//		if (countMap[sx][sy] != 0) {
//			int tmp = map.get(sx).get(sy).size();
//			for (int i = 0; i < tmp; i++) {
//				map.get(sx).get(sy).poll();
//			}
//			countMap[sx][sy] = 0;
//		}
		for (int i = 0; i < S; i++) {
			maxFish = 0;
			copyFish();
			moveFish();
			moveShark();
			sharkEat();
			flushFish();
			smellDown();
		}
		countFish();
		System.out.println(ans);
	}

	private static void smellDown() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (smell[i][j] == 0) {
					continue;
				}
				smell[i][j]--;
			}
		}
	}

	private static void countFish() {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				ans += countMap[r][c];
			}
		}
	}

	private static void flushFish() {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				// 해당 위치에서 모든 물고기에 만큼 돌림
				int tmp = copyMap.get(r).get(c).size();
				for (int i = 0; i < tmp; i++) {
					map.get(r).get(c).add(copyMap.get(r).get(c).poll());
					countMap[r][c]++;
				}
			}
		}
	}

	private static void copyFish() {
		copyMap = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			copyMap.add(new ArrayList<>());
			for (int j = 0; j < 4; j++) {
				copyMap.get(i).add(new ArrayDeque<>(map.get(i).get(j)));
			}
		}
	}

	private static void sharkEat() {
		for (int j = 0; j < 3; j++) {
			int x = moveList.get(j)[0];
			int y = moveList.get(j)[1];
			if (countMap[x][y] != 0) {
				smell[x][y] = 3;
				countMap[x][y] = 0;
				int size = map.get(x).get(y).size();
				for (int i = 0; i < size; i++) {
					map.get(x).get(y).poll();
				}
			}
		}
		sx = moveList.get(2)[0];
		sy = moveList.get(2)[1];
	}

	private static void moveShark() {
		List<int[]> list = new ArrayList<>();
		dfs(list, 0, sx, sy, -1);
	}

	private static void dfs(List<int[]> list1, int fish, int nx, int ny, int a) {
		if (list1.size() == 3) {
			if (fish >= maxFish) {
				maxFish = fish;
				moveList = list1;
//				System.out.println(Arrays.toString(list1.get(0)));
//				System.out.println(Arrays.toString(list1.get(1)));
//				System.out.print(Arrays.toString(list1.get(2)));
//				System.out.println(fish);
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			// 왔던길 안가기
			// 제자리는 갈 수 있음

			int nsx = nx + dsr[d];
			int nsy = ny + dsc[d];
			if (nsx >= 0 && nsx < 4 && nsy >= 0 && nsy < 4) {
				List<int[]> list = new ArrayList<>(list1);
				list.add(new int[] { nsx, nsy });
				if (a != -1 && list1.size() != 1 && (a + 2) % 4 == d) {
					dfs(list, fish, nsx, nsy, d);
				}else {
					dfs(list, fish + countMap[nsx][nsy], nsx, nsy, d);
				}
			}
		}
	}

	private static void moveFish() {
		// 모든 4*4에서
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				// 해당 위치에서 모든 물고기에 만큼 돌림
				int tmp = map.get(r).get(c).size();
				out: for (int i = 0; i < tmp; i++) {
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
							tmpQueue.add(new int[] { nr, nc, d }); // 물고기 추가
							continue out;
						}
						d--;
						if (d == -1) {
							d += 8;
						}
					} // 8번 돌때까지 별 문제 없었으면 그냥 안움직이고 넘어감
					tmpQueue.add(new int[] { r, c, d }); // 물고기 추가
				}
			}
		}
		while (!tmpQueue.isEmpty()) {
			int[] fish = tmpQueue.poll();
			map.get(fish[0]).get(fish[1]).add(fish[2]);
		}
	}
}