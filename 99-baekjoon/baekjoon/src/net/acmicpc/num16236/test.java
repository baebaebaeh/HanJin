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

public class test {
	public static void main(String[] args) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			return o1[2] - o2[2];
		});
		queue.add(new int[] {1, 2, 3});
		queue.add(new int[] {2, 2, 3});
		queue.add(new int[] {3, 2, 3});
		queue.add(new int[] {4, 2, 4});
		queue.add(new int[] {2, 1, 3});
		for (int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(queue.poll()));			
		}
	}
}