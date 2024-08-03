package modifier03_protected;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        
        // 같은 패키지 접근가능.
        p.age = 30;
        
    }
}
