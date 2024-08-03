package net.acmicpc;

import java.util.Scanner;

public class num1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int NOS = sc.nextInt(); // 스위치개수
		int[] eachSwitch = new int[NOS]; // 스위치배열
		for (int i = 0; i < NOS; i++) {
			eachSwitch[i] = sc.nextInt(); // 초기 스위치 설정
		}
		int studentNum = sc.nextInt(); // 학생수
		int[] genderAndNum = new int[studentNum * 2];
		for (int i = 0; i < studentNum * 2; i++) {
			genderAndNum[i] = sc.nextInt(); // 짝수 : 성별, 홀수 : 받은스위치번호
		}
		
		for (int i = 0; i < studentNum; i++) {
			int switchNum = genderAndNum[i * 2 + 1];
			int gender = genderAndNum[i * 2];
			
			if (gender == 1) { // 남자면
				for (int j = switchNum; j <= NOS; j+=switchNum)
					eachSwitch[j - 1] = eachSwitch[j - 1] == 1 ? 0 : 1;
			} else { // 여자면
				int index = switchNum - 1;
				eachSwitch[index] = eachSwitch[index] == 1 ? 0 : 1;
				int tempI = 1;
				while (index-tempI >= 0 && index+tempI <= NOS-1 && 
						eachSwitch[index - tempI] == eachSwitch[index + tempI]) {
					eachSwitch[index - tempI] = eachSwitch[index - tempI] == 1 ? 0 : 1;
					eachSwitch[index + tempI] = eachSwitch[index + tempI] == 1 ? 0 : 1;
					tempI++;
				}
			}
		}

        for (int i = 0; i < NOS; i++) {
            System.out.print(eachSwitch[i] + " ");
            if ((i + 1) % 20 == 0) { // 20개씩 줄바꿈
                System.out.println();
            }
        }
	}
}
