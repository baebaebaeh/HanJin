package com.swea.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class swea1225_queue {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 모든 테스트 케이스
		for (int iter = 1; iter <= 10; iter++) {
			// 한줄 띄기
			br.readLine();
			bw.write("#" + iter + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			// 초기 queue 생성
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			// 빼줄값 설정
			int num = 1;
			// queue의 첫번째 값에서 빼줄값 뺐을때 0 이하가 되기 전까지 실행
			while (queue.peek() - num > 0) {
				// queue에서 첫번째 값에서 빼줄값 빼주고 마지막으로 add
				queue.add(queue.remove() - num);
				// 빼줄값 ++
				num++;
				// 빼줄값이 6일때 1로 설정
				if (num == 6) num = 1;
			}
			// 0 이하가 되기 전까지 실행이여서 첫번째 값을 제거후
			queue.remove();
			// 마지막값에 0 추가
			queue.add(0);
			// 출력
			for (int i = 0; i < 8; i++) {
				bw.write(queue.remove() + " ");
			}
			bw.write("\n");
		}
		bw.flush();
//		bw.write("#" + iter + " " + ans + "\n");
//		bw.flush();
	}
}