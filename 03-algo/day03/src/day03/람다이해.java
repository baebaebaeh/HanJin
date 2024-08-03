package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 람다이해 {
	static class Student implements Comparable<Student> {
		String name;
		int age;

		public Student() {
		}

		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}

		@Override
		public int compareTo(Student o) {
			return this.name.compareTo(o.name);
		}
	}

	static class StudentComp implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}
	}

	static class arrComp implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}
	}

	public static void main(String[] args) {
		int[][] arr = {
				{1, 5},
				{3, 2},
				{1, 2},
				{2, 3}
		};
		Arrays.sort(arr, new arrComp());
		/*
		 * 	익명클래스
		 * 	new 상속받은 클래스명|상속받은 인터페이스명() {
		 * 		내용정의
		 * 	}
		 */

//		Comparator<int[]> comp = new Comparator<int[]>() { // 익명클래스, 인터페이스를 상속받는다고 했으니 재정의 또한 해야한다.
//			
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if (o1[0] == o2[0]) {
//					return o1[1] - o2[1];
//				}
//				return o1[0] - o2[0];
//			}
//		};
		
		Arrays.sort(arr, new Comparator<int[]>() { // 익명클래스, 인터페이스를 상속받는다고 했으니 재정의 또한 해야한다.
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
//		Arrays.sort(arr, (o1, o2) -> {
//				if (o1[0] == o2[0]) {
//					return o1[1] - o2[1];
//				}
//				return o1[0] - o2[0];
//			}
//		});
		
		// 아래는 위와 같다. 하지만 위는 익명클래스로 만듦
//		static class arrComp implements Comparator<int[]> {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if (o1[0] == o2[0]) {
//					return o1[1] - o2[1];
//				}
//				return o1[0] - o2[0];
//			}
//		}
		System.out.println(Arrays.deepToString(arr));
		
		// 정렬 : Comparable, Comparator - compare(비교1, 비교2)
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 22));
		students.add(new Student("장보고", 32));
		students.add(new Student("임꺽정", 27));
		// 그냥 콜렉션즈 쓰면 무엇이 기준인지 몰라서 오류난다
		// 그래서 implements comparable을 해준다.
//		Collections.sort(students); // Comparable
//		Collections.sort(students, new StudentComp());
//		
//		System.out.println(students);
	}
}
