package test02_polymorphism;

public class IPhone implements AlarmSound{

	@Override
	public void playAlarm() {
		System.out.println("Beep beep beep!");
	}

}
