package test05_user_exception;

// 
public class FruitNotFoundRuntimeException extends RuntimeException{
	public FruitNotFoundRuntimeException(String name) {
		super(name+"이 없습니다.");
	}
}
