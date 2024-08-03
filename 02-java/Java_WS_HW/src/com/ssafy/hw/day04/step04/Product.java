package com.ssafy.hw.day04.step04;

/**
 * 상품 정보를 나타내는 클래스
 */
public class Product {
	String pCode;
	String pName;
	int price;
	int quantity;
	String brand;
	String desc;
	
	public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Product [pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", brand=" + brand + ", desc=" + desc + "]";
	}
}
