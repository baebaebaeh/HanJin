package com.ssafy.offline;
class Parent { }
class ChildA extends Parent {}
class ChildB extends Parent {}
class GrandChildA extends ChildA {}

public class CastTest {
	public static void main(String[] args) {
		/*
			Parent p = new Parent();  	// o
			Parent p = new ChildA();  	// o
			Parent p = new ChildB();	// o
			ChildA a = new ChildB();	// x
			ChildA a = new GrandChildA();	// o
			ChildB b = new GrandChildA();	// x
		 	========================================
		 	
		 	Parent p = new Parent();
		 	ChildA a = p;			// 컴파일 에러
		 	ChildA a = (ChildA)p;	// 런타임 에런
		 	
		 	Parent p = new ChildA();  // 묵시적(부 = 자)
		 	ChildA a = p;	// 컴파일 에러
		 	ChildA a = (ChildA)p;
		 
		 
		 */
		
		
		// A 타입 = B 타입 
		// 묵시적(암묵적) 형변환
		// 	A(부모) = B(자식)
		
		// 명시적 형변환
		//  A(자식) = (형변환)B(부모)
//		Parent p = new Parent();  	// o
//		Parent p = new ChildA();  	// o
//		Parent p = new ChildB();	// o
//		ChildA a = new ChildB();	// x
//		ChildA a = new GrandChildA();	// o
//		ChildB b = new GrandChildA();	// x
//	 	========================================
//	 	
//	 	Parent p = new Parent();
//	 	ChildA a = p;			// 컴파일 에러
//	 	ChildA a = (ChildA)p;	// 런타임 에런
//	 	
	 	Parent p = new ChildA();  // 묵시적(부 = 자)
//	 	ChildA a = p;	// 컴파일 에러
	 	ChildA a = (ChildA)p;
	 	System.out.println("성공");
	}
}
















