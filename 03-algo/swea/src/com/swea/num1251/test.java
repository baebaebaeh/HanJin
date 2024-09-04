package com.swea.num1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test {
	static double[] xArr;
	static double[] yArr;

	public static void main(String[] args) throws IOException {
		int N = 10;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				System.out.println(i * N + j);
			}
		}
//			double leng = Math.sqrt(x * y);
	}
}
