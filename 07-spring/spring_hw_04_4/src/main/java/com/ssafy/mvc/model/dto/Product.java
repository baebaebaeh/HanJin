package com.ssafy.mvc.model.dto;

public class Product {
	/** 상품 코드 */
	private String pCode;
	/** 상품 이름 */
	private String pName;
	/** 상품 가격 */
	private int price;
	/** 상품 수량 */
	private int quantity;
	/** 상품 브랜드 */
	private String brand;
	/** 상품 설명 */
	private String pDesc;


	public Product() {
	}


	public Product(String pCode, String pName, int price, int quantity, String brand, String pDesc) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.pDesc = pDesc;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getpDesc() {
		return pDesc;
	}


	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}


	@Override
	public String toString() {
		return "Product [pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", brand=" + brand + ", pDesc=" + pDesc + "]";
	}

	
	




	

}
