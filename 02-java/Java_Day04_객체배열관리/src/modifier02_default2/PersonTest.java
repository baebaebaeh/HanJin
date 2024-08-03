package modifier02_default2;

import modifier02_default.Person;

// 다른 패키지에 있는 다른 클래스.
public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        // default는 다른 패키지에서 접근할 수 없다.
    }
}
