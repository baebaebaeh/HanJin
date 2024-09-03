package net.acmicpc.num2206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2206_Solution {
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input2206.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = string.charAt(j) - '0';
            }
        }

        int result = bfs();
        bw.write(result + "\n");
        bw.flush();
    }

    static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];  // [벽을 부수지 않은 경우][벽을 부순 경우]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});  // r, c, 거리, 벽을 부쉈는지 여부
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            int wallBroken = curr[3];

            if (r == N - 1 && c == M - 1) {
                return dist;  // 도착점에 도달한 경우
            }

            for (int d = 0; d < 4; d++) {
                int row = r + dr[d];
                int col = c + dc[d];

                if (row < 0 || row >= N || col < 0 || col >= M) {
                    continue;
                }

                if (map[row][col] == 0 && !visited[row][col][wallBroken]) {
                    visited[row][col][wallBroken] = true;
                    queue.add(new int[]{row, col, dist + 1, wallBroken});
                }

                if (map[row][col] == 1 && wallBroken == 0 && !visited[row][col][1]) {
                    visited[row][col][1] = true;
                    queue.add(new int[]{row, col, dist + 1, 1});
                }
            }
        }

        return -1;  // 도달할 수 없는 경우
    }
}
