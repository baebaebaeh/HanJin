package com.ssafy.hw.day08.step04;

import java.util.List;

/**
 * 상품리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 *
 */
public interface IProductManager {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean removeProduct(String pCode);
	int sell(String pCode, int cnt);
	Product[] getProductList();
	Product searchByCode(String pCode);
	boolean addReview(Review review);
	boolean removeReview(Review review);
	List<Review> getProductReview(String pCode);
	Product[] searchByName(String name);
	long getTotlPrice();
	Product[] getProducts();
	Refrigerator[] getRefrigerators();
	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
}
