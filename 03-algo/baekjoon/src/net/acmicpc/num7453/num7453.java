package net.acmicpc.num7453;

import java.io.*;
import java.util.*;

public class num7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // AB 배열의 합과 CD 배열의 합을 저장할 리스트
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        // AB 배열 정렬
        Arrays.sort(AB);
        // CD 배열 정렬
        Arrays.sort(CD);

        long count = 0;
        int left = 0;
        int right = n * n - 1;

        // 투 포인터를 사용하여 두 배열의 합이 0이 되는 경우의 수를 찾는다
        while (left < n * n && right >= 0) {
            int sum = AB[left] + CD[right];
            if (sum == 0) {
                long leftCount = 0;
                long rightCount = 0;

                // 같은 값이 몇 개 있는지 확인
                int leftValue = AB[left];
                while (left < n * n && AB[left] == leftValue) {
                    leftCount++;
                    left++;
                }

                int rightValue = CD[right];
                while (right >= 0 && CD[right] == rightValue) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
