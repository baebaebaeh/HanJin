package com.ssafy.class1;

public class Test07_Array {
	public static void main(String[] args) {
		int score1 = 80;
		int score2 = 80;
		int score3 = 80;
		int score4 = 80;
		
		// 배열은 같은 타입이면서 동일한 의미를 가질경우 하나의 변수로 여러개의 값을 관리 할 수 있다.
		int[] arr = new int[4];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
		arr[1] = 100;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
		String[] arr2 = new String[2];
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		
		Member[] arr3 = new Member[2];
		arr3[0] = new Member();
		Member m = arr3[0];
		m.age = 100;
		m.name = "hong";
		System.out.println(arr3[0].name);
		
	}
}










