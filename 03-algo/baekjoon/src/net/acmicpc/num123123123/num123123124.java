package net.acmicpc.num123123123;

import java.io.*;
import java.util.*;

public class num123123124 {
    static int N, M;
    static int[] lessons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lessons = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int maxLesson = 0;
        int totalSum = 0;

        // 레슨 정보를 배열에 담고, 최대 레슨 길이와 총합을 구합니다.
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            maxLesson = Math.max(maxLesson, lessons[i]);
            totalSum += lessons[i];
        }

        // 이진 탐색을 위한 범위 설정 (최소값: 가장 긴 레슨, 최대값: 모든 레슨의 합)
        int left = maxLesson;
        int right = totalSum;
        int result = totalSum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    // 블루레이 크기가 capacity일 때, M개 이하로 레슨을 나눌 수 있는지 확인하는 함수
    private static boolean canDivide(int capacity) {
        int count = 1;  // 블루레이 개수
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            // 현재 레슨을 담을 수 없다면, 새로운 블루레이 사용
            if (currentSum + lessons[i] > capacity) {
                count++;
                currentSum = lessons[i];

                // 블루레이 개수가 M을 넘으면 false
                if (count > M) {
                    return false;
                }
            } else {
                currentSum += lessons[i];
            }
        }

        return true;
    }
}
