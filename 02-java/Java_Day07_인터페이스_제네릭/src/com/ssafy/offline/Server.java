package com.ssafy.offline;
/*
 * 객체 생성 불가능
 * 자식클래스를 이용하여 사용한다.
 * 클래스가 인터페이스를 구현하기 위해서 
 * implements 키워드를 사용한다.
 * 
 * 인터페이스 extends 인터페이스 (다중상속)
 * 클래스    extends 클래스 (단일상속)
 * 클래스    implements 인터페이스, 인터페이스, 인터페이스, ... (다중구현)
 */
public interface Server {
	int PORT = 80; // public final static
	void start();
	abstract void stop(); // 위는 abstract가 생략되어있는 상태다
	public abstract void restart(); // 위는 public이 생략되어있는 상태다
}
