package offline;
class Parent {
	Parent() {
		System.out.println(1);
	}
	Parent(String name) {
		System.out.println(2);
	}
}













class Child extends Parent {
	Child() {
		// Recursive constructor invocation Child()
//		this();
		this(100);
		// Constructor call must be the first statement in a constructor
//		super();
		System.out.println(3);
	}
	Child(int num) {
		super("a");
		System.out.println(4);		
	}
}
public class Test02 {
	public static void main(String[] args) {
		new Child();
	}
}












