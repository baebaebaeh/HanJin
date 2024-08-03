package test03_binding_test;


class Parent {
    String x = "parent x";
    
    public void method() {
        System.out.println("parent method.");
    }
    
    public static void static_method() {
    	System.out.println("parent static method.");
    }
}

class Child extends Parent{
    String x = "child x"; // 사실은 이렇게 쓰는 경우가??
    // 멤버 변수: 하이딩.
    
    
    // 멤버 메서드: 오버라이드
    @Override
    public void method() {
        System.out.println("child method.");
    }
    
    public static void static_method() {
    	System.out.println("child static method.");
    }
}

public class BindingTest {
    
    public static void main(String[] args) {
    	Parent p = new Child();
    	Child c = new Child();
    	
//    	System.out.println(p.x); // parent?
    	p.method(); // child
//    	p.static_method(); // parent
//    	System.out.println(c.x); // child
    	c.method(); // child
//    	c.static_method(); // child
    	
    	// static 메서드는 어차피 클래스의 것이므로
//    	Parent.static_method();
    	
    	
    	// 다형성
    	// - 행위에 대한 내용
    	// - 객체가 가지고 있는 메서드에만 적용
    	// - 동적 바인딩 : 상속 + 오버라이드
    	// - 오버라이드 : 상속 관계에 있을 때, 자식 클래스가 부모 클래스의 메서드를 재정의!
    	
    	// => 멤버 메서드에는 다형성이 적용되지만,
    	// => 멤버변수에는 다형성이 적용되지 않는다.
    	// => static 메서드에는 다형성이 적용되지 않는다.
    	
   
        
    }

}
