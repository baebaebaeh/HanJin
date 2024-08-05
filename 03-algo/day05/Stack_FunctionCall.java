
public class Stack_FunctionCall {

	public static void main(String[] args) {
		System.out.println("1 main 호출");
		func1();
		System.out.println("2 main 종료");
	}

	public static void func1() {
		System.out.println("3 func1 호출");
		func2();
		String name = "Kim";
		System.out.println(name);
		System.out.println("4 func1 종료");
	}

	public static void func2() {
		System.out.println("5 func2 호출");
		String name = "Lee";
		System.out.println(name);
		func3();
		System.out.println("6 func2 종료");
	}

	public static void func3() {
		System.out.println("7 func3 호출");
		System.out.println("8 func3 종료");
	}

}
