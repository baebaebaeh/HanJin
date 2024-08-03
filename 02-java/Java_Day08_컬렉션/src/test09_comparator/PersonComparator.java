package test09_comparator;

import java.util.Comparator;

// 2. Comparator를 구현한다.
// 제네릭 :  비교대상의 타이븡ㄹ 적어준다
public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
}
