package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Mark {
	char data;
	int r;
	int c;

	public Mark(char data, int r, int c) {
		super();
		this.data = data;
		this.r = r;
		this.c = c;
	}
}

public class BaekJoon_3184 {

	static int R, C;
	static char[][] map;
	static int vSurv = 0;
	static int oSurv = 0;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String l = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = l.charAt(c);
			}
		}
		System.out.println(Arrays.deepToString(map));
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'v' || map[r][c] == 'o') {
					BFS(new Mark(map[r][c], r, c));
				}
			}
		}
		System.out.println(oSurv + " " + vSurv);
	}

	private static void BFS(Mark m) {
		Queue<Mark> queue = new LinkedList<Mark>();
		int curR = m.r;
		int curC = m.c;
		int vCnt = 0, oCnt = 0;
		queue.offer(m);
		while (!queue.isEmpty()) {
			Mark cur = queue.poll();
			curR = cur.r;
			curC = cur.c;
			if (cur.data == 'v') {
				vCnt++;
			} else if (cur.data == 'o') {
				oCnt++;
			}
			map[curR][curC] = '#';
			for (int i = 0; i < 4; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#') {
					queue.offer(new Mark(map[nr][nc], nr, nc));
				}
			}
		}
		if (vCnt >= oCnt) {
			vSurv += vCnt;
		} else if (vCnt < oCnt) {
			oSurv += oCnt;
		}
	}
}