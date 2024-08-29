package com.swea.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class swea0000 {
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/input1218.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}