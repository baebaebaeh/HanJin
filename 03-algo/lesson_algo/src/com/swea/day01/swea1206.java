package com.swea.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class swea1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int iter = 0; iter < 10; iter++) { // 10개의 테스트 케이스
            StringTokenizer st1 = new StringTokenizer(br.readLine()); // 두줄 읽는다
            StringTokenizer st2 = new StringTokenizer(br.readLine()); // 두줄 읽는다
            int N = Integer.parseInt(st1.nextToken()); // 건물의 개수
            int[] hight = new int[N]; // 건물의 개수만큼 건물높이배열 만들기
            for (int i = 0; i < N; i++) { // 건물높이배열에 값 넣기
                hight[i] = Integer.parseInt(st2.nextToken());
            }
            int sum = 0; // 조망권 확보된 세대수
            int[] hightArr = new int[4];
            for (int j = 2; j < N - 2; j++) { // 두번째 건물부터 마지막에서 두번째건물까지
                hightArr[0] = hight[j - 2]; // 현재 건물 양옆 2칸까지 최대값 구하기
                hightArr[1] = hight[j - 1];
                hightArr[2] = hight[j + 1];
                hightArr[3] = hight[j + 2];
                Arrays.sort(hightArr); 
                if (hightArr[3] < hight[j]) // 주변 높이 최대값이 현재 건물보다 낮으면
                    sum += hight[j] - hightArr[3]; // 현재 건물-최대값을 더해줌
            }
            bw.write("#" + (iter + 1) + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}