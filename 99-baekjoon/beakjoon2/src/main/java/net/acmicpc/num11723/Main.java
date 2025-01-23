package net.acmicpc.num11723;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("data/num11723.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> hashSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        boolean isExist = false;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int x = 0;

            switch (commend) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    hashSet.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    hashSet.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    isExist = hashSet.contains(x);
                    if (isExist) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    isExist = hashSet.contains(x);
                    if (isExist) {
                        hashSet.remove(x);
                    } else {
                        hashSet.add(x);
                    }
                    break;
                case "all":
                    for (int iter = 1; iter <= 20; iter++) {
                        hashSet.add(iter);
                    }
                    break;
                case "empty":
                    hashSet.clear();
                    break;
            }
            // switch끝
        }
        // for 끝
        bw.flush();
    }
}
