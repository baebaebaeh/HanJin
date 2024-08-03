package test07_abstract;


// 추상 클래스의 자식 클래스는
// 1. 모든 추상 메서드를 오버라이드하던지 => 일반 클래스이므로 객체 생성 가능
// 2. 오버라이드 하지 않으면 여전히 추상 클래스로 남게됨.
public abstract class AnimalChild extends Animal{

	public AnimalChild(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

}
