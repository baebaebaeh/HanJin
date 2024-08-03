package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		// set
		// 순서없고 중복 허용 x
		// 집합을 나타내는 자료구조
		// 구현체로 hashSet 사용
		// 자바쩜 유틸
		// 중복을 허용하지 않으니 동일성을 판단한다
		// 동일성팒단 hashcode equals
		
		Set<String> names = new HashSet<>();
		
		names.add("luna");
		names.add("max");
		names.add("luna");
		names.add("daisy");
		names.add("max");
		
		System.out.println(names);
		// 출력 [max, daisy, luna] 순서가 바뀐다
		
		
		
	}
}
