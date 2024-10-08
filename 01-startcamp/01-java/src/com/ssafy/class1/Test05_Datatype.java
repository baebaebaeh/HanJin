package com.ssafy.class1;

public class Test05_Datatype {
	public static void main(String[] args) {
		/*
		기본타입
		  - 형태상으로 소문자로 시작됨
		  - 미리 정해져서 추가 불가능
		  - 8개
		  	숫자(6개) : 
		  		정수(4개) : byte(1byte), short(2byte), int(4byte), long(8byte)         
		  		실수(2개) : float(4byte), double(8byte)
		  	문자(1개) : char(2byte)
		  	논리(1개) : boolean(1byte), true, false
		  		
		  - 데이터 타입의 형변환
		    byte < short < int < long < float < double 		
		  		   char  < int < long < float < double
		참조타입
		  - class(사용자 정의 클래스 포함), 배열 등등... 
		  
		 */
		int i = 100;
		System.out.println(i);
		// (타입)값;
		System.out.println((char)i);  // i 변수의 값을 문자로 변환
		
		int j = 'a';
		System.out.println(j);
		
		// 산술연산시의 주의점
		// int로 자동형변환 되는 것들의 산술연산의 결과는 int
		// long과 int로 자동형변환 되는 것들의 산술연산의 결과는 long
		// float과 int로 자동형변환 되는 것들의 산술연산의 결과는 float
		// double과 int로 자동형변환 되는 것들의 산술연산의 결과는 double
		/*
		 *   int + int = int
		 *   int + char = int
		 *   char + char = int
		 * 
		 *   long + int = long
		 *   long + long = long
		 *   float + int = float
		 *   float + long = float
		 *   ..
		 *   double + long = double
		 *   ..
		 */
		System.out.println(5 / 2);	// 
		System.out.println((int)(5 / 2));
		System.out.println((double)(5 / 2));
		System.out.println((double)5 / 2);
		
		char c1 = 'a';
//		char c2 = 'ab';  // error
		String s = "ab";
//		char c3 = "a";   // error
	}
}





























