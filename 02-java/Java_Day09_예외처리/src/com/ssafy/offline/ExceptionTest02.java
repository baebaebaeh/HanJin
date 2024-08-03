package com.ssafy.offline;


class MyCheckedException extends Exception {}  // checked Exception
class MyUnCheckedException extends RuntimeException {} // unchecked Exception
//class CarPriceException extends Exception {}


// 예외를 클래스로 만들어서 생성자를 두개 만든다
// RuntimeException에 컨트롤 클릯해서 들어가보면
//     public RuntimeException(String message) {
//		super(message);
//		}
class CarPriceException extends RuntimeException { 
	CarPriceException(){
		super("가격은 0보다 커야 합니다.");
	}
	CarPriceException(String msg){
		super(msg);
	}
}
class Car {
	String name;
	int price;
	// 아래의 Car생성하는 곳에서는 예외를 던져주는것이 맞다
	// Car를 관리하는곳에서 예외를 보는게 맞지 생성자에서 오류가 나게 하면 안됨.
	// 그래서 throws로 책임을 ExceptionTest02에 넘겨주자
	public Car(String name, int price) throws CarPriceException {
		if (price < 0) {
			throw new CarPriceException("가격은 0보다 커야 합니다. (" + price +")");
		}
		this.name = name;
		this.price = price;
	}
}

public class ExceptionTest02 {
	public static void main(String[] args) {
		try {
			Car c1 = new Car("모닝", 1100);
			Car c2 = new Car("테슬라 모델 X", -1); 
		} catch (CarPriceException c) {
			c.printStackTrace();
		}
		// if문으로 예외처리하면 눈으로 보기 힘들다
		// throw로 예외처리하면 보기 편하다

		
		

//		throw new MyUnCheckedException();  //오류 안남
//		throw new MyCheckedException();    //오류 남 (내가 의도함)
		
	}
}
