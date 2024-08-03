package day03;

import java.util.Arrays;
import java.util.Comparator;

class Idol {
	String name;
	int age;

	public Idol(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Idol() {
	}

	@Override
	public String toString() {
		return "Idol [name=" + name + ", age=" + age + "]";
	}
}

public class 람다연습 {
	// 옛날방식
	static class IdolComp implements Comparator<Idol> {
		@Override
		public int compare(Idol o1, Idol o2) {
			return o1.age - o2.age;
		}
		
	}
	
//	Comparator<Idol> IdolComp = new Comparator<Idol>() { // 익명클래스, 인터페이스를 상속받는다고 했으니 재정의 또한 해야한다.
//
//		@Override
//		public int compare(Idol o1, Idol o2) {
//			return o1.age - o2.age;
//		}
//	};
	
	
	public static void main(String[] args) {
		Idol[] arrays = new Idol[3];
		arrays[0] = new Idol("코딩왕 윤지", 20);
		arrays[1] = new Idol("디버깅왕 반장", 22);
		arrays[2] = new Idol("디자인왕 연주", 21);
		
		Arrays.sort(arrays, new IdolComp());
		// 위 아래는 같다.
		Arrays.sort(arrays, (o1, o2) -> {return o1.age - o2.age;});
//		Arrays.sort(arrays, (o1, o2) -> return o1.age - o2.age); // 한줄이면 이렇게 더 줄일 수 있다.
		
		System.out.println(Arrays.toString(arrays)); // 오류남
		
	}
}

