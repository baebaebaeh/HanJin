package net.acmicpc.num13424gpt;

import java.util.*;
import java.io.*;

public class num13424 {
    static final int INF = 100000000;
    static int[][] dist;

    public static void dijkstra(int start, int[][] graph, int[] dist, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > dist[curNode]) continue;

            for (int i = 1; i <= n; i++) {
                if (graph[curNode][i] != INF && dist[i] > curDist + graph[curNode][i]) {
                    dist[i] = curDist + graph[curNode][i];
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("data/input13424.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(graph[i], INF);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[u][v] = graph[v][u] = w;
            }

            int k = Integer.parseInt(br.readLine());
            int[] friends = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            dist = new int[k][n + 1];
            for (int i = 0; i < k; i++) {
                dijkstra(friends[i], graph, dist[i], n);
            }

            int minTotalDist = INF;
            int meetingPoint = -1;

            for (int i = 1; i <= n; i++) {
                int totalDist = 0;
                for (int j = 0; j < k; j++) {
                    totalDist += dist[j][i];
                }
                if (totalDist < minTotalDist) {
                    minTotalDist = totalDist;
                    meetingPoint = i;
                }
            }

            sb.append(meetingPoint).append("\n");
        }

        System.out.println(sb.toString());
    }
}
