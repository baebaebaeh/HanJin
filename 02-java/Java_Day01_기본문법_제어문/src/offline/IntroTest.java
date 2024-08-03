package offline;

import java.util.Scanner;

public class IntroTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		int n = sc.nextInt();
		sc.nextLine();  // 줄넘김 문자 제거
		String s = sc.next();
		sc.nextLine();  // 줄넘김 문자 제거
		String line = sc.nextLine();
		*/
		
		/*
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		String line = sc.nextLine();
		*/
		/*
 		이름 : 홍길동
 		나이 : 22
 		이메일 : hong@a.com
 		주소 : 조선 한양
		 */
		String name = sc.next();
		int age = sc.nextInt();
		String email = sc.next();
//		sc.nextLine();  // 줄넘김 문자 처리하기
		String addr = sc.nextLine();
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(addr);
		
	}
}








