package net.acmicpc.num17471;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	static int[] sel;
	static int N = 6;
	static int R;
	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= N / 2; i++) {
			sel = new int[i];
			R = i;
			comb(0, 0);
		}
	}
	static void comb(int start, int startIdx) {
		if (startIdx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = start; i <= N - R + startIdx; i++) {
			sel[startIdx] = i;
			comb(i + 1, startIdx + 1);
		}
	}
}