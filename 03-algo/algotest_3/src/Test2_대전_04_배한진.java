import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2_대전_04_배한진 {
	static int N, M, W, B, O; // WBO는 각각의 집합의 개수
	static int[][] map; //W = 1, B = 2, O = 3
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		//W = 1, B = 2, O = 3
		for (int TC = 1; TC <= testCase; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = 0;
			B = 0;
			O = 0;
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String string = br.readLine();
				for (int j = 0; j < M; j++) {
					char color = string.charAt(j);
					// W면 1 B면 2 O면 3을 map에 넣는다.
					if (color == 'W') {
						map[i][j] = 1;
					} else if (color == 'B') {
						map[i][j] = 2;
					} else {
						map[i][j] = 3;
					}
				}
			}
			// 입력받기 끝
			
			// 모든 노드에서 dfs 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 이미 확인 했던 곳이면 continue;
					if (map[i][j] == 0) {
						continue;
					}
					// 확인한곳 0만들고 해당 색의 집합개수 늘려주러 가기
					dfs(i, j, map[i][j]);
				}
			}
			// 출력
			bw.write(("#" + TC + " " + B + " " + O + " " + W + "\n")); ;
		}
		bw.flush();
	}
	private static void dfs(int row, int col, int color) {
		Queue<int[]> q = new ArrayDeque<>();
		// 현재위치 넣어주고
		q.add(new int[] { row, col });
		// 현재위치 0으로 바꿔주고
		map[row][col] = 0;
		// color에 따라 집합의 개수를 늘려준다.
		if (color == 1) {
			W++;
		} else if (color == 2) {
			B++;
		} else {
			O++;
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 현재 좌표
			int r = now[0];
			int c = now[1];
			// 상하좌우탐색
			for (int d = 0; d < 4; d++) {
				// 다음 좌표
				int nr = r + dr[d];
				int nc = c + dc[d];
				// 벗어나지 않고 해당 map이 같은색일때
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && 
						map[nr][nc] == color) {
					q.add(new int[] {nr, nc});
					// 확인해서 0으로 바꿔줌
					map[nr][nc] = 0;
				}
			}
		}
	}
}
