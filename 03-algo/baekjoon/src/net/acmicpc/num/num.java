package net.acmicpc.num;

import java.io.*;
import java.util.*;

public class num {
	//long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	////실험할 코드 추가   
	//long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	//long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
	//System.out.println("시간차이(m) : "+secDiffTime);
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
	}
}