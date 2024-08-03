package test05_inheritance;

public class Test {
    public static void main(String[] args) {
    	
//    	Animal ani = new Animal();
    	// 추상 메서드가 없더라도
    	// abstract 키워드가 붙어있으면 추상 클래스이고
    	// 객체 생성이 불가능하다.
    	
    	Animal[] animals = new Animal[3];
    	
		animals[0] = new Cat("Luna", 3);
		animals[1] = new Dog("Max", 4);
		animals[2] = new Cow("Daisy", 2);
		
		for(Animal animal : animals) {
			animal.eat();
			animal.speak();
		}
		
		// 상속을 통해서 (다형성을 통해서)
		// 코드의 중복을 줄여봤으나..
		// 상속 이후에 쓰이지 않는 코드가 있다.
		
		
    }
}
