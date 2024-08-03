/*
 * 단을 입력하세요(시작단) : 2
 * 단을 입력하세요(종료단) : 4
 * 2 * 1 =  2    3 * 1 =  3   4 * 1 =  4
 * 2 * 2 =  4  생략
 * 생략....
 * 2 * 9 = 18    3 * 9 = 27   4 * 9 = 36 
 */
package offline;

import java.util.Scanner;

public class GuguTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단을 입력하세요(시작단) : ");
		int start = sc.nextInt();
		System.out.print("단을 입력하세요(종료단) : ");
		int end = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			for (int dan = start; dan <= end; dan++) {
				System.out.printf("%d * %d = %2d    ", dan, i, dan * i);
			}
			System.out.println();
		}
	}
 }















