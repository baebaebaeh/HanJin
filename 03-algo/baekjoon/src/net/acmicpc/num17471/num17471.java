package net.acmicpc.num17471;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node {
	int[] child;
	int num;
	int color = 0; // 0=red 1=blue
}

public class num17471 {
	static int N, R, red, blue, ans;
	static Node[] nodes;
	static int[] sel;
	static boolean[] visited;
	static boolean D;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input17471.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nodes = new Node[N + 1];
		visited = new boolean[N + 1];
		ans = Integer.MAX_VALUE;
		// Node[] 배열 채우기
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node();
		}
		// Node 클래스에 모두입력받기
		for (int i = 1; i <= N; i++) {
			nodes[i].num = sc.nextInt();
		}
		// 자식은 배열로 받기
		for (int i = 1; i <= N; i++) {
			int tmp = sc.nextInt();
			int[] arr = new int[tmp];
			for (int j = 0; j < tmp; j++) {
				arr[j] = sc.nextInt();
			}
			nodes[i].child = arr;
		}
		// 조합 구하기
		// 조합 구할때 1개뽑는조합 부터 N / 2 조합 구할때까지 구함
		for (int i = 1; i <= N / 2; i++) {
			sel = new int[i];
			R = i;
			// 메서드 이름만 comb고 comb안에 bfs 사용함
			comb(1, 0);
		}
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}

	static void comb(int start, int startIdx) {
		// 멈춤조건
		if (startIdx == R) {
			// 아래 주석 해제하면 어떻게 나오는지 알 수 있음
//			System.out.println(Arrays.toString(sel));
			// 위의 sel된 번호들의(선거구) color를 blue로 바꿔줌 *****************************
			for (int i = 0; i < R; i++) {
				nodes[sel[i]].color = 1;
			}
			// 첫번재 blue를 찾으면 첫번째 blue에서만 bfs하면서 방문체크해줌
			for (int i = 1; i <= N; i++) {
				if (nodes[i].color == 1) {
					bfs(i, 1);
					break;
				}
			}
			// 첫번째 red에서도 방문체크
			for (int i = 1; i <= N; i++) {
				if (nodes[i].color == 0) {
					bfs(i, 0);
					break;
				}
			}
			// 0번째 인덱스는 무조건 방문을 안하니 false가 맞고
			// 1~N 번째 인덱스에서 false가 발견되면 안이어진 선거구 발견한거임
//			System.out.println(Arrays.toString(visited));
			
			// D는 안이어진 선거구가 존재하는지 판별
			D = true;
			for (int i = 1; i <= N; i++) {
				// 하나라도 발견하면 false
				if (!visited[i]) {
					D = false;
				}
			}
			blue = 0;
			red = 0;
			// 안이어진 선거구가 없으면
			if (D) {
				for (int i = 1; i <= N; i++) {
					// 모든 red인 선거구 인구수 static red에 더하기
					if (nodes[i].color == 1) {
						blue += nodes[i].num;
					}
					// 모든 blue인 선거구 인구수 static blue에 더하기
					if (nodes[i].color == 0) {
						red += nodes[i].num;
					}
				}
				// 두개 빼서
				int tmp = Math.abs(blue - red);
				// ans 비교하고 업데이트
				if (ans > tmp) {
					ans = tmp;
				}
			}
			// 다시 방문 false로 바꿔주고
			Arrays.fill(visited, false);
			
			// *********에서 바꿔줬었던 애들 원상 복귀
			for (int i = 0; i < R; i++) {
				nodes[sel[i]].color = 0;
			}
			return;
		}
		// 아래는 comb 외운거
		for (int i = start; i <= N + 1 - R + startIdx; i++) {
			sel[startIdx] = i;
			comb(i + 1, startIdx + 1);
		}
	}

	
	// 그냥 bfs인데 노드의 child중 같은 색깔인 경우만 true로 바꿔주는 메서드
	private static void bfs(int idx, int color) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(nodes[idx]);
		visited[idx] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < node.child.length; i++) {
				int nextIdx = node.child[i];
				Node nextNode = nodes[nextIdx];
				if (!visited[nextIdx] && nextNode.color == color) {
					visited[nextIdx] = true;
					q.add(nextNode);
				}
			}
		}
	}
}
