package net.acmicpc.num2470;

import java.io.*;
import java.util.*;

public class num2470 {
    static long[] arr;
    static int N;
    static int leftIdx, rightIdx;

    public static void main(String[] args) throws IOException {
        // 입출력 세팅 (이 부분은 문제 제출 시에는 지워도 됩니다)
        System.setIn(new FileInputStream("data/input2470.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        
        // 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        // 배열 정렬
        Arrays.sort(arr);
        
        // 두 포인터 사용
        leftIdx = 0;
        rightIdx = N - 1;
        
        long minSum = Long.MAX_VALUE;
        int left = 0, right = N - 1;

        while (left < right) {
            long sum = arr[left] + arr[right];

            // 현재 합이 절대값이 더 작은 경우, 최솟값을 업데이트
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                leftIdx = left;
                rightIdx = right;
            }

            // 합이 0보다 크면 오른쪽 포인터 이동 (작은 수와 더 큰 값을 더해야 함)
            if (sum > 0) {
                right--;
            } 
            // 합이 0보다 작으면 왼쪽 포인터 이동 (큰 수와 더 작은 값을 더해야 함)
            else if (sum < 0) {
                left++;
            } 
            // 합이 0이면 바로 종료 (최적의 값)
            else {
                break;
            }
        }

        // 결과 출력
        bw.write(arr[leftIdx] + " " + arr[rightIdx] + "\n");
        bw.flush();
    }
}
