package test05_overriding;

public class Test {
	public static void main(String[] args) {
		// 설계도에 생성자를 하나라도 프로그래머가 정의한다면
		// 컴파일러가 자동으로 기본 생성자를 만들어 주지 않는다.
		Person p = new Person();
//		p.
		p.eat();
		
		Student st = new Student("Park", 28, "Java");
//		st.study();
		st.eat();
		
//		st.
		
	}
}
