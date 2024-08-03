package temp;

interface TestForSaban {
	public abstract void method1();

	public default void method2() {
		method4();
		method5();
		System.out.println("default method");
	};

	public static void method3() {
		method5();
		System.out.println("static method");
	}

	private void method4() {
		System.out.println("private method");
	}

	private static void method5() {
		System.out.println("private static method");
	}
}

public class Test implements TestForSaban {


	public static void main(String[] args) {
		TestForSaban test = new Test();
		test.method1();
		test.method2();
		TestForSaban.method3();
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
}