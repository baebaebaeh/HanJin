package net.acmicpc.num17837;

import java.io.*;
import java.util.*;

public class num17837_refact {
	static int N, K, turn;
	static int[][] color, count;
	static List<List<Queue<Integer>>> map;
	static List<Stack<Integer>> location;
	static Deque<Integer> deque;
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input17837.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		turn = 0;
		color = new int[N][N];
		count = new int[N][N];
		map = new ArrayList<>();
		deque = new ArrayDeque<>();
		location = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			location.add(new Stack<>());
		}
		for (int i = 0; i < N; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map.get(i).add(new ArrayDeque<>());
			}
		}

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				color[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			// 상우하좌로 변경
			if (d == 2) {
				d = 3;
			} else if (d == 3) {
				d = 0;
			} else if (d == 4) {
				d = 2;
			}
			location.get(i).add(d);
			location.get(i).add(r);
			location.get(i).add(c);
			map.get(r).get(c).add(i);
			count[r][c]++;
			if (count[r][c] >= 4) {
				System.out.println(-1);
				return;
			}
//			map 설명
//			[ [ [0, 1, 2] [] [] [] [] [] ]
//			  [ [] [] [] [] [] [] ]
//			  [ [] [] [] [3, 4] [] [] ]
//		 	  [ [] [] [] [] [] [] ]
//		 	  [ [] [] [] [] [] [] ] ]
		}
		// 입력받기 끝

		// 0흰 1빨 2파
		// 출력이 1000넘으면 -1
		// 상우하좌
		out2: while (true) {
			turn++;
			out: for (int i = 0; i < K; i++) {
//				for (int[] a : count)
//					System.out.println(Arrays.toString(a));
//				System.out.println();
//				for (int j = 0; j < N; j++) {
//					for (int j2 = 0; j2 < N; j2++) {
//						System.out.print(map.get(j).get(j2).toString());
//					}
//					System.out.println();
//				}
//				System.out.println();
				// 현재위치
				int c = location.get(i).pop();
				int r = location.get(i).pop();
				int d = location.get(i).pop();
				int nr = r + dr[d];
				int nc = c + dc[d];
				// 다음위치가 파란색이거나 map을 벗어나면
				// 방향을 바꾸고 다음위치를 업데이트 해준다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || color[nr][nc] == 2) {
					d += 2;
					d %= 4;
					nr = r + dr[d];
					nc = c + dc[d];
					// 바꾼 다음 위치가 한번더 파란색이거나 map을 벗어나면
					// 멈춘다.
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || color[nr][nc] == 2) {
						location.get(i).add(d);
						location.get(i).add(r);
						location.get(i).add(c);
						continue out;
					}
				}
				int startIdx = map.get(r).get(c).peek();
				if (startIdx == i) {
					startIdx = Integer.MAX_VALUE;
				}
				// 내가 원하는 idx가 나올때 까지 뺏다가 넣는다.
				while (true) {
					int idx = map.get(r).get(c).poll();
					if (idx == i)
						break;
					map.get(r).get(c).add(idx);
				}
				// 다음 위치에 넣어준다.
				deque.add(i);
				// 위치 업데이트
				location.get(i).add(d);
				location.get(i).add(nr);
				location.get(i).add(nc);
				count[r][c]--;
				count[nr][nc]++;
				if (count[nr][nc] >= 4) {
					break out2;
				}
				while (!map.get(r).get(c).isEmpty()) {
					int tmpIdx = map.get(r).get(c).peek();
					if (tmpIdx != startIdx) {
						int idx = map.get(r).get(c).poll();
						deque.add(idx);
						// 위치 업데이트
						int tmpC = location.get(idx).pop();
						int tmpR = location.get(idx).pop();
						location.get(idx).add(tmpR + dr[d]);
						location.get(idx).add(tmpC + dc[d]);
						count[tmpR][tmpC]--;
						count[tmpR + dr[d]][tmpC + dc[d]]++;
						if (count[tmpR + dr[d]][tmpC + dc[d]] >= 4) {
							break out2;
						}
						continue;
					}
					break;
				}
				if (color[nr][nc] == 1) {
					while (!deque.isEmpty()) {
						int idx = deque.pollLast();
						map.get(nr).get(nc).add(idx);
					}
				} else {
					while (!deque.isEmpty()) {
						int idx = deque.poll();
						map.get(nr).get(nc).add(idx);
					}
				}

			}
			if (turn == 1001) {
				break;
			}
		}
		if (turn >= 1001) {
			System.out.println(-1);
		} else {
			System.out.println(turn);
		}
	}
}
