package net.acmicpc.num11726;

import java.util.Scanner;

public class num11726 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        System.out.println(fibo3(N+1));

    }


    static int fibo3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        return dp[n];
    }
}