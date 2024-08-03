/*
 * Object 사용
 * 장점
 * 단점 : 값을 꺼낼 때 형변환을 해야한다
 *       특정 데이터 타입으로 제한 할 수 없다.
 *       실행 시점에 에러가 발생하는 것을 알 수 있다.
 *       
 *       
 *       
 * Generic
 */
package com.ssafy.offline;

import java.util.ArrayList;
import java.util.List;

class Box {
//	String data; 이러면 스트링밖에 못담음
	Object data; //이러면 모든 타입 다 받을 수 있다.
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
/*
 * class 클래스이름 <타입파라미터>를 붙혀서 만들어준다.
 * 권장하는 1차 후보이름
 * T : Type
 * E : Element
 * K : Key
 * V : Value
 * N : Number
 * 
 * 			class Box    -> Box b = new Box();
 * 			class GenericBox<T> -> GenericBox<String> b = 
 * 								   new GenericBox<String>();
 */
class GenericBox<T> { 
//	Object data; 이러면 코드 첫줄에 
//	설명되어있듯이 단점이 존재
	T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
class DoubleBox<T, E> {
	T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}



















public class GenericTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
//		list.add(100); 오류남
		
		DoubleBox<String, Integer> dBox = new DoubleBox<>();
		
//		GenericBox box = new GenericBox();
		//GenericBox is a raw type. References to generic type GenericBox<T> should be parameterized
		//제네릭을 썼는데 사용을 안해서 그냥 제네릭 안붙인걸로 해주겠다.
		
		GenericBox<String> box = new GenericBox<String>();
		box.setData("문자열 담기");
		// 아래 주석 풀어서 보면 컴파일 오류가 난걸 알 수 있다.
//		box.setData(1);
		String data = box.getData(); // Object와는 다르게 형변환을 안해도 된다.
		System.out.println(data);
		
		GenericBox<Integer> numBox = new GenericBox<Integer>();
//		numBox.setData("문자열 담기");
		// 위 주석 풀어서 보면 컴파일 오류가 난걸 알 수 있다.
		numBox.setData(1);
		int value = numBox.getData(); // Object와는 다르게 형변환을 안해도 된다.
		System.out.println(data);
		
		
		
		
		/*
		 * 아래는 Object활용해서
		 */
		/*
		Box numberBox = new Box();
		numberBox.setData("문자열 데이터");
		numberBox.setData(1);
//		위와같이 하면 box 에는 문자열형이 아닌 데이터가 들어가는 걸 막을 수 없다
		String data = (String)numberBox.getData();
		System.out.println("data : " + data);
		*/
	}
}
