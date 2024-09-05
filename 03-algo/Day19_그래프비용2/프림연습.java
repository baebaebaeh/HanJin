
import java.util.*;
public class 프림연습 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner("7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n" 
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ "");
		
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] adj = new int[V][V];
		for (int i=0; i<E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			adj[v1][v2] = adj[v2][v1] = w;
		}
		
		int[] p = new int[V]; // 루트
		int[] D = new int[V]; // 비용
		boolean[] v = new boolean[V]; // 방문
		Arrays.fill(p, -1);
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] =0; // 시작점 0
		
		int ans =0;
		for (int i=0; i<V; i++) {
			// 최소값 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j=0; j<V; j++) {
				if ( !v[j] && minCost > D[j] ) {
					minCost = D[j];
					minVertex = j;
				}
			}
			
			ans += minCost;
			v[minVertex] = true;
			
			// 최소인 정점의 인접한 정점들의 비용 업데이트
			for (int j=0; j<V; j++) {
				// 두 지점이 연결 되어있다 <-> 가중치가 있다 <-> != 0
				// && 방문 안했으면
				// D[j] > adj[minVertex][j] <-> distance에 있는 값이 연결된 노드 값도가 크다면 <-> 더 작은값으로 업데이트
				if (adj[minVertex][j] != 0 && !v[j] && D[j] > adj[minVertex][j]) { 
					D[j] = adj[minVertex][j];
					p[j] = minVertex;
				}
			}
		}
		System.out.println(ans);
	}
}
