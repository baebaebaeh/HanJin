package test08_comparable;

import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	static class Idol implements Comparable<Idol>{
		String name;
		int age;
		int fanCount;


		@Override
		public String toString() {
			return "Idol [name=" + name + ", age=" + age + ", fanCount=" + fanCount + "]";
		}


		public Idol(String name, int age, int fanCount) {
			super();
			this.name = name;
			this.age = age;
			this.fanCount = fanCount;
		}


		public Idol(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		
		/*
		 *     public int compareTo(T o);
	} comparable에 들어가보면 이게있으니 구현해야한다
		 */
		
		// other자리에 들어오는애가 비교대상
		// a.compareTo(other)일때 a가 기준
		// 리턴값이 음수면 기준이 비교대상 앞 -> 기준 비교
		// 리턴값이 양수면 비교대상이 기준 앞 -> 비교 기준
		// 나이순으로 정렬
		// 나이가 같으면 이름의 역순으로 출력
		// comparator란 기존compare를 기본적으로 사용하고 다른 기준으로
		// 정렬하는것을 선택지로 남기고 싶을 때 사용
		
		@Override
		public int compareTo(Idol other) { 
			if ((this.age - other.age) != 0) {
				return this.age - other.age;				
			}
			return this.name.compareTo(other.name) * -1;
			
		}
	}
	
	static class IdolComparator implements Comparator<Idol> {
		@Override
		public int compare(Idol o1, Idol o2) {
			return o1.fanCount - o2.fanCount;
		}
	}
	
	public static void main(String[] args) {
		
		List<Idol> list = new ArrayList<>();
		list.add(new Idol("카리나", 24 ,100));
		list.add(new Idol("윈터", 23, 70));
		list.add(new Idol("장욱", 27, 1000));
		list.add(new Idol("진종수", 30, 1000));
		//Collections의 메서드를 쓸때는 comparable인터페이스 타입이여야함
//		Collections.sort(list); // 객체를 담은거는 일단은 못함
//		System.out.println(list);
		
		Collections.sort(list, new IdolComparator());
		
		/*
		 * public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence,
               Constable, ConstantDesc {
               
               String도 Comparable을 구현한 모습
               그래서 아래에서 String은 Collection을 사용가능해진다.
               따라서 Idol이라는 데이터타입도 Comparable을 구현해야한다.
		 */
		
		// 추가수업때문에 아래 주석으로 막음
		/*
		List<Integer> sList1 = new ArrayList<>();
		sList1.add(10);
		sList1.add(20);
		sList1.add(30);
		sList1.add(15);
		
		Collections.sort(sList1); //아스키 코드 기준 오름차순
		
		System.out.println(sList1);
		
		
		
		
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
		
		Collections.sort(person);  
		//person으로 바꾸니 sort에 문제가 생김
		// 사용자 정의 클래스를 사용한 리스트는 기보넞ㄱ으로 정렬할 수 없다.
		// comparable 인터페이스 구현 또는  comparator클래스를 정으ㅢ
		// 비교기준이 없어서 사용자 정의 클래스에 비교 기준을 만들어준다.
		System.out.println(person); 
		//String의 경우 알파벳 순서대로, 오름차순으로 설정
		// Number의 경우 숫자 순서대로
		// 한글도 됨
		 */
	}
}
