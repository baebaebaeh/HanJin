package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num3184 {
	//long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	////실험할 코드 추가   
	//long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	//long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	//System.out.println("시간차이(m) : "+secDiffTime);
	static int sheep;
	static int wolf;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int d = 0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input8958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String string = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = string.charAt(c);
			}
		}
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < C - 1; c++) {
				
			}
		}
	}
	private static void bfs() {
		Queue<Character> queue = new LinkedList<>();
		int tempSheep = 0;
		int tempWolf = 0;
		while ()
	}
}