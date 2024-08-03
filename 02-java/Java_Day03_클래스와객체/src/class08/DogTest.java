package class08;

public class DogTest {
	public static void main(String[] args) {
		Dog d = new Dog("메리", 4);
		System.out.println(d.name);
		System.out.println(d.age);
		
		Dog d2 = new Dog(); // 컴파일러가 기본생성자를 안만들어줘서.
		
		d2.eat().drink(); // 메서드 체이닝
		
	}
}
