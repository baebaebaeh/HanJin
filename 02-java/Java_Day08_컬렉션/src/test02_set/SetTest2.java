package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
	public static void main(String[] args) {
		
		Set<Person> set = new HashSet<>();
		
		set.add(new Person("luna", 3));
		set.add(new Person("luna", 3));
		
		
		// set에는 한사람? 두사람?
		// set이 같다고 판단하는 기준은 hashcode가 같으면서 equals도 같아야한다
		System.out.println(set);
		// 사용자 정의 클래스를 사용하는 경우
		// set을 사용하기 위해서는 해시코드와 이퀄스를 재정의 해줘야함나다.
	}
}
