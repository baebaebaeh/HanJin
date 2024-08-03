package test05_user_exception;

// CheckedException : Exception 상속
// - 클래스, 객체 생성
// - 생성자
public class FruitNotFoundException extends Exception {

	public FruitNotFoundException(String name) {
		super(name + "에 해당하는 과일이 없습니다!");
		// 생성자에 넣는 문자열 => 예외 메시지.
	}
}
