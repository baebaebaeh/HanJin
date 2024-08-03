package com.ssafy.ws.day06.step04;

/**
 * 한식 맛집 정보를 나타내는 클래스
 */
public class KoreanRestaurant extends Restaurant{
	String number;
	String breakTime;
	public KoreanRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KoreanRestaurant(int resId, String name, String address, String signatureMenu, int rate, 
			String number, String breakTime) {
		super(resId, name, address, signatureMenu, rate);
		this.number = number;
		this.breakTime = breakTime;
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	@Override
	public String toString() {
		return "KoreanRestaurant"+ "[resId=" + resId + ", name=" + name + ", address=" + address + ", signatureMenu="
				+ signatureMenu + ", rate=" + rate + ", number=" + number + ", breakTime=" + breakTime + "]";
	}
}
