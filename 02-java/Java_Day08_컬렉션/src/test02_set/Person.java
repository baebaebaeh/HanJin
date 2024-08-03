package test02_set;

public class Person {
	String name;
	int age;
	
	
	@Override
	public int hashCode() {
		// 일반적으로 String은 같은 문자열에 대해서 같은 해시코드가 나온다.
		// name의 해시코드만 사용해서 구별하자
		return name.hashCode();
	}
	
	//같으면 true 다르면 false
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.age == p.age;
		}
		return false;
	}

	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}
