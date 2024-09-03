package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st1.nextToken());
		st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());

		int[] cake = new int[L]; // 케이크 누가 찜했는지 배열 1이면 찜 0이면 아직
		int[] wantAudi = new int[2]; // [[번호-1][원하는개수]]
		int[] eatAudi = new int[2]; // [[번호-1][원하는개수]]

		for (int iter = 0; iter < N; iter++) {
			st1 = new StringTokenizer(br.readLine());
			int temp1 = 0; // 원하는방청객이랑 연관
			int temp2 = 0; // 먹는방청객이랑 연관
			int P = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			for (int i = P - 1; i < K; i++) { // 원하는 만큼 돌려
				if (cake[i] != 1) { // 이미 1이면 넘어가라
					cake[i] = 1; // cake가 1이 아니면 1로 바꾸고
					temp2++; // 몇개 먹었는지 ++
				}
				temp1++; // 몇개 원하는지 ++
			}
			if (wantAudi[1] < temp1) { // 원하는게 더 많았으면 바꿔주고
				wantAudi[0] = iter;
				wantAudi[1] = temp1;
			}
			
			if (eatAudi[1] < temp2) { // 먹은게 더 많았으면 바꿔주고
				eatAudi[0] = iter;
				eatAudi[1] = temp2;
			}
		}
		bw.write(wantAudi[0]+1 + "\n"); // 프린트
		bw.write(eatAudi[0]+1 + "\n");
		bw.flush();
	}
}
