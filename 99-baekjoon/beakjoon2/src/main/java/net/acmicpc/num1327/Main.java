package net.acmicpc.num1327;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static int N, K;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("data/num1327.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        int temp = 0; // 임시 넣을 변수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= K; i++) {

            int index = 0; // 1번부터 K까지의 인덱스 차례차례
            for (int idx = 0; idx < K; idx++) {
                if (arr[idx] == i) {
                    index = idx;
                }
            }
            if (N % 2 == 0) {

            } else {

            }
        }
    }
    static void cul1(int index) {
        for (int plus = N - 1; plus > 0; plus -= 2) {
            
        }
    }
}
