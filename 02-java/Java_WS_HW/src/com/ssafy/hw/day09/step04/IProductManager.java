package com.ssafy.hw.day09.step04;

import java.util.List;

/**
 * 상품리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 *
 */
public interface IProductManager {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean removeProduct(String pCode);
	int sell(String pCode, int cnt) throws QuantityException, ProductCodeNotFoundException;
	Product[] getProductList();
	Product searchByCode(String pCode) throws ProductCodeNotFoundException;
	boolean addReview(Review review);
	List<Review> getProductReview(String pCode) throws ReviewNotFoundException;
	Product[] searchByName(String name) throws NameNotFoundException;
	long getTotalPrice();
	Product[] getRefrigerators();
	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
}
