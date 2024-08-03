package com.ssafy.offline;

import java.util.Random;

class Test01 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("첫번째 주자~~~ 두둥.... ");
		Thread.sleep(2000);
		System.out.println(new Random().nextInt(21) + 1);
		
//		Test01Manager m1 = new Test01Manager();
//		Test01Manager m1 = Test01Manager.getInstance();
//		m1.info();
	}
}
