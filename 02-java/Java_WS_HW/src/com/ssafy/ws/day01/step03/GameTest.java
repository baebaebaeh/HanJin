package com.ssafy.ws.day01.step03;

import java.util.Scanner;

/**
 * 가위,바위,보 게임을 하는 클래스
 */
public class GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 게임 메뉴 출력
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");

		int menu = sc.nextInt(), // 사용자가 선택한 메뉴 변수
				comWin = 0, userWin = 0, // 컴퓨터, 사용자가 승리한 카운트 변수
				comNo = 0, userNo; // 컴퓨터, 사용자가 선택한 가위,바위,보 숫자

		// 사용자가 선택한 메뉴에 따라 총치뤄야하는 게임 카운트와 승리조건을 충족하는 카운트를 결정한다.
		int[][] cntInfo = { {}, { 5, 3 }, { 3, 2 }, { 1, 1 } };
		int winCnt = cntInfo[menu][1];
		// 진행중인 게임 횟수가 총 게임 카운트를 넘지 않으며 컴퓨터,사용자의 승리 카운트가 승리조건을 만족하지 못한다면 반복
		for (int i = 0; i < cntInfo[menu][0]; i++) {
			System.out.println("가위바위보 중 하나 입력: ");
			comNo = (int) (Math.random() * 3); // 난수로 컴퓨터 가위,바위,보 선택
			System.out.println(comNo);
			userNo = sc.nextInt(); // 입력으로 사용자 가위,바위,보 선택
			if (userNo == comNo) {
				System.out.println("비겼습니다.");
			} else if ((userNo + 1) % 3 == comNo) {
				System.out.println("졌습니다.");
				comWin++;
			} else {
				System.out.println("이겼습니다.");
				userWin++;
			}
			if (comWin >= winCnt || userWin >= winCnt)
				break;
		}

		// 사용자 승리횟수와 컴퓨터 승리횟수 비교하여 최종 결과 출력
		String msg = "### 컴퓨터 승!!!";
		if (userWin == comWin || (userWin < winCnt && comWin < winCnt)) {
			msg = "### 무승부!!!";
		} else if (userWin > comWin) {
			msg = "### 사용자 승!!!";
		}
		System.out.println(msg);
		sc.close();
	}
}
