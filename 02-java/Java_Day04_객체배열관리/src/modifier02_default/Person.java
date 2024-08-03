package modifier02_default;

public class Person {
	// default : 같은 패키지안에서 접근 가능.
    String name;
    int age;
    
    public void info() {
        System.out.printf("이름: %s, 나이: %d\n", name, age);
    }
}
