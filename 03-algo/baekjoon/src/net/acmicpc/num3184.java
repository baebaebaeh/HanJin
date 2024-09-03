package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num3184 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	static int sheep;
	static int wolf;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int d = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input3184.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sheep = 0;
		wolf = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String string = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = string.charAt(c);
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				bfs(r, c);
			}
		}
		bw.write(sheep + " " + wolf);
		bw.flush();
	}

	private static void bfs(int r, int c) {
		// 좌표값을 배열로 받는 queue생성
		Queue<int[]> queue = new LinkedList<>();
		int tempSheep = 0;
		int tempWolf = 0;
		int[] arr = { r, c };
		// 울타리로 감싸지지 않으면 true로 바뀜
		boolean out = false;
		queue.add(arr);
		// queue가 빌때까지 돌린다.
		while (!queue.isEmpty()) {
			// 하나꺼내서
			arr = queue.poll();
			// 그 좌표가 벽이면(#) 다음좌표 꺼내라
			if (map[arr[0]][arr[1]] == '#')
				continue;
			// 상하좌우의 방향을 체크해서 out값 판단과 queue에 들어갈 값 판단
			for (d = 0; d < 4; d++) {
				// 모든 방향(상하좌우)이 바운더리를 벗어나는지 확인
				if (arr[0] + dr[d] < 0 || arr[0] + dr[d] >= map.length || arr[1] + dc[d] < 0
						|| arr[1] + dc[d] >= map[0].length) {
					// 벗어나면 울타리로 감싸지지 않은 상태로 간주
					out = true;
					// 벗어나면 다음 방향으로 바꿈
					continue;
				}
				// 바운더리를 안 벗어났을때의 방향의 값이 #이 아닐때
				if (map[arr[0] + dr[d]][arr[1] + dc[d]] != '#') {
					// 그 방향의 값을
					int[] tempArr = { arr[0], arr[1] };
					tempArr[0] += dr[d];
					tempArr[1] += dc[d];
					// queue에 넣어준다
					queue.add(tempArr);
				}
			}
			// queue에서 나온값이 v면 늑대++
			if (map[arr[0]][arr[1]] == 'v')
				tempWolf++;
			// queue에서 나온값이 o면 양++
			if (map[arr[0]][arr[1]] == 'o')
				tempSheep++;
			// queue에서 나온값을 #으로 바꿔줌
			map[arr[0]][arr[1]] = '#';
		}
		// 울타리로 안감싸졌으면 아무것도 하지말고 return
		if (out == true)
			return;
		// 울타리로 감싸졌으면 늑대와 양 비교후 스테틱변수에 더해주기
		if (out == false) {
			if (tempWolf >= tempSheep)
				tempSheep = 0;
			if (tempSheep > tempWolf)
				tempWolf = 0;
			sheep += tempSheep;
			wolf += tempWolf;
		}
	}
}