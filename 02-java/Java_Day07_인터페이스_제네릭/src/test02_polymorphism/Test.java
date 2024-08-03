package test02_polymorphism;

public class Test {
	public static void main(String[] args) {
		// 인터페이스와 다형성
		// 인터페이스: 타입으로도 사용 가능
		// 해당 인터페이스를 구현한 클래스로 만든 객체를 , 해당 인터페이스로 참조할 수 있다.
		// 실제 객체의 행위가 일어난다.
		// 해당 인터페이스에 정의되어 있는 내용만 보인다.
		// 
		AlarmSound galaxyPhone = new GalaxyPhone();
		AlarmSound iPhone = new IPhone();
		
//		galaxyPhone.
		
		
		galaxyPhone.playAlarm();
		iPhone.playAlarm();
		
		AlarmSound[] phones = {new GalaxyPhone(), new IPhone()};
		for(AlarmSound phone : phones) {
			phone.playAlarm();
		}
		
	}
}
