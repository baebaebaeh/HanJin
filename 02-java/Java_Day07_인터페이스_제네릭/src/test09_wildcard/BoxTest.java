package test09_wildcard;

// 제네릭 클래스
// < >안에 타입 파라미터를 정해준다.
class Box <T> { // Number : 숫자만 가능!
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	// 제네릭 메서드
	public <U> void printClassName(U item) {
		System.out.println("Item type: "+item.getClass().getName());
	}
	
}

public class BoxTest {
	public static void main(String[] args) {
		Box<?> parent = new Box<Integer>();
		Box<? extends Integer> a = new Box<Integer>();
		Box<? super Double> b = new Box<Object>();

		
		
		
		
	}
}
