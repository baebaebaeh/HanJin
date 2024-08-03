package test01_interface;

// 인터페이스는 그자체로는 객체 생성이 안되므로
// 반드시 일반 클래스에 의해 구현되어야 함!
// 구현: 클래스 implements 인터페이스
// 상속: 클래스 extends 상위클래스
//      인터페이스 extends 인터페이스
public class MyClass implements MyInterface {

	@Override
	public void method1() {
		System.out.println("method 1");
		
	}

	@Override
	public void method2() {
		System.out.println("method 2");
		
	}
	
//	@Override
//	public void method3() {
//		재정의할 수는 있다.
//	}
	// 1. 인터페이스의 모든 추상메서드를 재정의
	// 2. 추상 클래스로 남는다.

}
