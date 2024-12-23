package com.swea.day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class swea1231 {
	static int[][] arrChild; // arr1[자기idx][0] = 첫번재자식idx, arr1[자기idx][1] = 두번재자식idx
	static String[] arrData; // arr1[자기idx] = 자기data
	static int child = 0;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1231.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int iter = 1; iter <= 10; iter++) {
			bw.write("#" + iter + " ");
			int N = Integer.parseInt(br.readLine());
			arrChild = new int[N + 1][2];
			arrData = new String[N + 1];
			for (int i = 0; i < N; i++) { // arr[myidx][자식들] = mydata
				StringTokenizer st = new StringTokenizer(br.readLine());
				int childCont = st.countTokens() - 2;
				int myIdx = Integer.parseInt(st.nextToken());
				String myData = st.nextToken();
				for (int j = 0; j < childCont; j++) {
					arrChild[myIdx][j] = Integer.parseInt(st.nextToken());
				}
				arrData[myIdx] = myData;
			}
//			System.out.println(Arrays.deepToString(arrChild));
//			System.out.println(Arrays.deepToString(arrData));
			inorder(1);
			bw.write("\n");
		}
		bw.flush();
	}

//	private static void inorder(int start) {
//		for (int i = 0; i < 2; i++) {
//			if (arrChild[start][i] != 0) {
//				inorder(arrChild[start][i]);
//			}
//		}
//		System.out.print(arrData[start]);
//	}

	private static void inorder(int start) throws IOException {
		if (arrChild[start][0] != 0) {
			inorder(arrChild[start][0]);
		}
		bw.write(arrData[start]); 
		if (arrChild[start][1] != 0) {
			inorder(arrChild[start][1]);
		}
	}
}