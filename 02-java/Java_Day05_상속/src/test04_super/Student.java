package test04_super;

// 상속을 할 때는 extends 키워드를 사용.
public class Student extends Person {
	String major;
	
	// 아무런 생성자도 정의하지 않은 상태
	// => 컴파일러가 기본생성자 Student(){}를 만들어 줌
	// => 생성자는 내부에 기본적으로 super(); 가 생략되어 있음
	// => 기본적으로 부모클래스의 기본생성자를 호출한다는 뜻!!
	
	// 빈 공간에서 ctrl + spacebar
	// public Student() {
		// super(); // 생성자 내부에는 기본적으로 super();가 생략되어 있다.
		// 내부적으로 Person()을 호출하고 있다.
		// 1. 프로그래머가 명시적으로 super()를 호출하지 않아도 
		//  => 기본적으로 super();를 호출
		// 2. 프로그래머가 명시적으로 super()를 호출하면??
		//  => super()를 넣어주지 않는다.
	// }
	
	// 마우스 우클릭 > Source > Generate Constructor ..
	public Student() {
		super(); // 자동으로 생략되어 있는 super()를 넣어준다.
	}
	
	public Student(String name, int age, String major) {
		// super(); // super()는 하나만 쓸 수 있다.
		super(name, age); // 부모의 생성자를 이용해 초기화
		this.major = major;
		// Alt + 방향키
		
	}
	
	
	
	void study() {
		super.eat();
		System.out.println("공부를 합니다.");
	}


}
