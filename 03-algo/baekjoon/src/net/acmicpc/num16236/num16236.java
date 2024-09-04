package net.acmicpc.num16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class num16236 {
	static int[][] map;
	static boolean[][] visited;
	static int size, eat, N, ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 초기 세팅
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		eat = 0;
		size = 2;
		ans = 0;
		visited = new boolean[N][N];
		// 입력받기
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		// 
		bfs(r, c, 0);
		System.out.println(ans);
	}

	private static void bfs(int R, int C, int D) {
		// 출발 위치 0으로 만들어줌
		map[R][C] = 0;
		// [r, c, dist]
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			// 기본적으로 
			return o1[2] - o2[2];
		});
		// 현재위치 방문했으니
		visited[R][C] = true;
		// 현재위치 queue에 넣고
		queue.add(new int[] { R, C, D });
		// 반복
		// queue가 텅 빌때까지 못찾으면 더이상 먹을 물고기가 없는것
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 꺼내서 입력받고
			int r = now[0];
			int c = now[1];
			int dist = now[2];
			// 현재위치의 물고기 사이즈가 먹을 수 있다면
			if (map[r][c] < size &&
					map[r][c] > 0) {
				// 먹고
				eat += 1;
				// 정답에 현재 위치 더한다.
				ans += dist;
				// 물고기 먹었으니까 현재 위치0
				map[r][c] = 0;
				// visited초기화 해주고
				for (int i = 0; i < N; i++) {
					Arrays.fill(visited[i], false);
				}
				// 먹은양이 사이즈랑 같으면
				if (eat == size) {
					// 사이즈 올려주고 eat = 0
					size++;
					eat = 0;
				}
				// 이러고 먹은위치 기준으로 다시 bfs시작
				bfs(r, c, 0);
				return;
			}
			// 현재위치의 물고기 사이즈가 먹을 수 없다면
			// 먹을 수 있을때까지 물고기 탐색시작
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N &&
						!visited[nr][nc]) {

					if (map[nr][nc] > size) {
						continue;
					}
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, dist + 1 });
				}
			}
		}
	}
}