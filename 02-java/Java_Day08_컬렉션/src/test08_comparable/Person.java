package test08_comparable;

//사용자 정의 클랫흐가 정렬되기 위해서는
// 비교기준이 필요
// 1. comparable 인터페이스 구현
public class Person implements Comparable<Person> {
	
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

	
	//Person 빨간줄에 add눌러주면 이게 나옴
	//add unimplemented methods//
	//
	@Override
	public int compareTo(Person o) {
		// 1. 나이
		// 나이를 기준으로 비교해보자
//		return this.age - o.age; //이걸 this랑 o를 바꿔주면 내림차순
								 // 비교대상 - 나 => 
		//음수면 자리유지 양수면 자리바꿈 0이면 동일위치
		
		// 2. 이름
//		return this.name.compareTo(o.name);
		
		// 3. 기본적으론 나이순으로 나이가 같다면 이름순으로
		if (this.age == o.age) {
			return this.name.compareTo(o.name); // 여기에 *-1해주면 부호가 바뀌기 때문에 역순이 된다.
		}
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
