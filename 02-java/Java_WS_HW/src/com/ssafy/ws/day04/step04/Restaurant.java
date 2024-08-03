package com.ssafy.ws.day04.step04;

/**
 * 맛집 정보를 나타내는 클래스
 */
public class Restaurant {
	int resId;
	String name;
	String address;
	String signatureMenu;
	int rate;

	public Restaurant(){}
	
	public Restaurant(int resId, String name, String address, String signatureMenu, int rate) {
		super();
		this.resId = resId;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Restaurant [resId=" + resId + ", name=" + name + ", address=" + address + ", signatureMenu="
				+ signatureMenu + ", rate=" + rate + "]";
	}
}
