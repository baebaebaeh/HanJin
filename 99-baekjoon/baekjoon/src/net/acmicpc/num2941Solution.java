package net.acmicpc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class num2941Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 10;
        int[] arr;
        for (int i = 0; i < 10; i++) {
             
            int buildingCount = Integer.parseInt(br.readLine());
            arr = new int[buildingCount+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < buildingCount; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int min;
            int sum = 0;
            // 더큰값이 있으면 건너띄고, 없을 경우 가장 큰값을 빼준다.
            OUT:
            for (int j = 2; j < buildingCount-1; j++) {
                min = Integer.MAX_VALUE;
                for (int j2 = 1; j2 <= 2; j2++) {
                    if(arr[j-j2] > arr[j] || arr[j+j2] > arr[j]) {
                        continue OUT;
                    }else {
                        int temp = Math.min(arr[j]-arr[j-j2], arr[j]-arr[j+j2]);
                        min = Math.min(temp, min);
                    }
                }
                sum += min;
            }
            bw.write("#"+(i+1)+" "+sum+"\n");
        }
        bw.flush();
    }
}