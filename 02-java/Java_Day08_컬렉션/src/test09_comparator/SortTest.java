package test09_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		// 정렬
		// --순서가 있는 자료구조 : List
		
		List<Person> person = new ArrayList<>();
		
		person.add(new Person("daisy", 5)); //알트쉬프트알 눌러서 person을 다른이름으로 바꿔보자
		person.add(new Person("max", 3));
		person.add(new Person("luna", 7));
		
//		names.add("배한진");
//		names.add("채건우");
//		names.add("이대현");
//		names.add("이동영");

//		names.add("daisyalice");
		
		System.out.println(person);
		
		
		// 정렬
		//--Collections 유틸리티 클래스의
		//sort()메서드 사용
		
		Collections.sort(person, new PersonComparator());  //이게 바뀌긴했는데 왜바꿈?
		
		//person으로 바꾸니 sort에 문제가 생김
		// 사용자 정의 클래스를 사용한 리스트는 기보넞ㄱ으로 정렬할 수 없다.
		// comparable 인터페이스 구현 또는  comparator클래스를 정의(Comparator 인터페이스를 구현해서)
		// 비교기준이 없어서 사용자 정의 클래스에 비교 기준을 만들어준다.
		System.out.println(person); 
		//String의 경우 알파벳 순서대로, 오름차순으로 설정
		// Number의 경우 숫자 순서대로
		// 한글도 됨
	}
}
