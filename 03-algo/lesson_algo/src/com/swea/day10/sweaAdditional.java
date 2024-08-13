package com.swea.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
싸피 대전 캠퍼스의 야경을 아름답게 바꾸기 위하여 LED 등을 이용한 조명을 설치하기로 하였다. 
LED 조명을 제어할 수 있는 새로운 시스템을 도입하기로 결정하였다. 
이 시스템은 다음과 같이 동작한다.
1번부터 N번까지 N개의 LED 등이 일렬로 설치된다.
LED 등을 제어하는 버튼은 1번부터 N번까지 있다.
LED는 On/Off의 두 가지 상태가 있다.
I번째 버튼을 누르면 i의 배수에 해당하는 LED 등이 상태가 바뀐다. 
(On상태의 LED는 Off되며, Off상태 LED는 On된다.)
예를 들어 아래와 같이 6개의 LED가 있는 경우, 왼쪽의 모두 꺼진 상태에서 2번 버튼을 누르면
오른쪽과 같이 2의 배수에 해당하는 LED 등의 상태가 바뀐다.

1    2    3    4    5    6        
off  off  off  off  off  off

2번 버튼을 누른 경우
1    2    3    4    5    6        
off  on   off  on   off  on

다시 3번 버튼을 누른 경우
1    2    3    4    5    6        
off  on   on   on   off  off


LED가 모두 꺼져 있는 상태에서 원하는 패턴으로 만들기 위해 스위치 조작을 하려고 한다.
원하는 LED 패턴이 주어질 때, LED가 모두 꺼진 상태에서 원하는 패턴을 만들기 위한 
최소 스위치 조작 횟수를 찾는 프로그램을 작성하라.

Input 내용
첫 줄 : T (테스트케이스)
두번째 줄 : N (N 은 1 <= N <= 100)
세번째 줄 : 스위치 상태 (N 개의 0 또는 1 로 이루어진 숫자)

Input 값
5
5
1 1 0 0 1
6
0 1 1 1 0 0
7
1 1 1 1 1 1 1
10
0 1 0 1 0 1 0 1 0 1
20
0 0 0 0 1 0 0 1 0 1 0 1 0 1 0 1 1 1 0 0

Output 값
#1 3
#2 2
#3 1
#4 1
#5 8
*/
class sweaAdditional {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("swea/inputAdditional.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int iter = 1; iter <= T; iter++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (arr[i] == 1) {
					for (int j = i; j <= N; j += i) {
						arr[j] = arr[j] == 1 ? 0 : 1;  
					}
					ans++;
				}
			}
			bw.write("#" + iter + " " + ans + "\n");
		}
		bw.flush();
	}
}