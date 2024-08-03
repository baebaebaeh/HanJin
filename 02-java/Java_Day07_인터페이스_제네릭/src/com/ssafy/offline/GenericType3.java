package com.ssafy.offline;
/*
 * 타입파라미터제한
 */
class GenericNumberBox<T extends Number> {
	
}

public class GenericType3 {
	public static void main(String[] args) {
		GenericNumberBox<Integer> box = new GenericNumberBox<>();
		GenericNumberBox<Double> box2 = new GenericNumberBox<>();
		// 아래는 오류가 난다. Number를 상속받는 타입만 T에 들어갈 수 있다.
		// 상속 유무는 컨트롤 클릭으로 들어가서 볼 수 있다.
//		GenericNumberBox<String> box3 = new GenericNumberBox<>();
	}
}
