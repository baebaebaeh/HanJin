/*
 * 추상(abstract) : 클래스, 메서드
 * 
 * 추상클래스
 * - 객체 생성이 불가능하다.
 * - 자식 클래스를 이용해서 활용한다.(객체의 형변환)
 * - 추상클래스의 추상 메서드는 
 *   반드시 자식 클래스에서 오버라이딩 해야 한다.
 * - 추상메서드를 반드시 선언할 필요는 없다.  
 * 추상메서드 
 * - 메서드에 abstract를 붙여서 사용
 * - 추상메서드를 가지고 있는 클래스는 추상클래스로 선언되어야 한다.
 *   
 */
package com.ssafy.offline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class AbsSuper {
	String name = "AbsSuper";
//	void call() {}
	abstract void call();
}
// The type AbsSub must implement the inherited abstract method AbsSuper.call()
class AbsSub extends AbsSuper {
	String name = "AbsSub";
	void call() {
		System.out.println("call : AbsSub");
	}
}











public class AbstractTest {
	public static void main(String[] args) {
		// Cannot instantiate the type AbsSuper
//		AbsSuper aSuper = new AbsSuper();
		AbsSuper aSuper = new AbsSub();
		System.out.println(aSuper.name);
		aSuper.call();
		
		printList(new ArrayList<>());       
		printList(new LinkedList<>());       
		printList(new AbsSub());       
	}
	
	static void printList(Object list) {
		
	}
}













