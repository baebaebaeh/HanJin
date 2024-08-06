package com.swea.google;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
 
class swea1493 {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("swea/input1493.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int iter = 1; iter <= T; iter++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int x = 1;
            int y = 0;
            int z = 1;
            int w = 0;
            // &(p)의 좌표 구하기
            // x = 1 인 행을 보면 1 + 1 , 1 + 1 + 2, 1 + 1 + 2 + 3 ... 규칙을 찾을 수 있다
            // p-1 이후 -1, -2, -3 을 마이너스 될때까지 반복 해주고 마지막에 빼준값을 다시 더해줌
            // 반복한 값을 y값으로 지정해줌
            // 남은 값을 x는 플러스 y는 마이너스
            int temp = 0; // while 반복 횟수
            p -= 1;
            while (p >= 0) {
                temp++;
                p -= temp;
            }
            p += temp;
            y = temp;
            x += p;
            y -= p;
             
             
            temp = 0; // while 반복 횟수
            q -= 1;
            while (q >= 0) {
                temp++;
                q -= temp;
            }
            q += temp;
            w = temp;
            z += q;
            w -= q;
             
             
            // 두 좌표 더해주기
            x += z;
            y += w;
            int ans = 0;
            // #(x, y) = [x] + [x + y - 2] - [x - 1] = x + [x + y - 2]   -> 대괄호는 1부터 해당값까지의 합
            for (int i = 1; i <= x + y - 2; i++) {
                ans += i;
            }
            ans += x;
            bw.write("#" + iter + " " + ans + "\n");
        }
        bw.flush();
    }
}