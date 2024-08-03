package offline;

import java.util.Random;

class Animal {
	public void info() { System.out.println("Animal의 info"); }
}
class Cat extends Animal {
	public void info() { System.out.println("Cat의 info"); }
}
class Dog extends Animal {
	public void info() { System.out.println("Dog의 info"); }
}
public class Test {
	public static void info(Animal a) {
		a.info();
	}
	public static void main(String[] args) {
		Animal a = new Animal();
		info(a);
		a = new Dog();
		info(a);
		a = new Cat();
		info(a);
		
		Animal a1 = new Animal();
		a1.info();
		Animal a2 = new Dog();
		a2.info();
		Animal a3 = new Cat();
		a3.info();
		
	}
}






