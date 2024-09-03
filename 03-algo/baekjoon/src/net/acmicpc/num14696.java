package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num14696 {
	// long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	//// 실험할 코드 추가
	// long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	// long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	// System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input14696.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			int[] A = new int[4];
			int[] B = new int[4];

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				A[Integer.parseInt(st.nextToken()) - 1]++;
			}

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				B[Integer.parseInt(st.nextToken()) - 1]++;
			}

			for (int j = 3; 3 >= 0; j--) {
				if (A[j] > B[j]) {
					bw.write("A" + "\n");
					break;
				}
				if (A[j] < B[j]) {
					bw.write("B" + "\n");
					break;
				}
				if (j == 0 && A[j] == B[j]) {
					bw.write("D" + "\n");
					break;
				}
			}
		}
		bw.flush();
	}
}