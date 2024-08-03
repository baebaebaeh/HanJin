package com.ssafy.hw.day05.step04;

import java.util.Arrays;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManager {
	private final int MAX_PRODUCT_SIZE = 100;
	private final int MAX_REVIEW_SIZE = 1000;
	private Product[] products = new Product[MAX_PRODUCT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int pCount;
	private int rCount;
	
	private Product pNull = new Product();
	private Review rNull = new Review();
	
	public boolean addProduct(Product product) {
		if (pCount < MAX_PRODUCT_SIZE) {
			products[pCount++] = product;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateProduct (Product product) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode() == product.getpCode()) {
				products[i] = product;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeProduct (String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode() == pCode) {
				products[i] = products[pCount-1]; // 마지막 상품을 지우고 싶은 자리에 추가
				products[pCount-1] = pNull; // 마지막 상품 지움
				pCount -= 1;
				return true;
			}
		}
		return false;
	}
	
	public int sell (String pCode, int cnt) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode() == pCode) {
				products[i].setQuantity(products[i].getQuantity()-cnt);
				return products[i].getQuantity()-cnt;
			}
		}
		return -1; // 동일 pCode가 없음
	}
	
	public Product[] getProductList () {
		Product[] tempProducts = new Product[pCount];
		for (int i = 0; i < pCount; i++) {
			tempProducts[i] = products[i];
		}
		return tempProducts;
	}
	
	public Product searchByCode (String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode() == pCode) {
				return products[i];
			}
		}
		return pNull; // null null 0 0 null null
 	}
	
	public boolean addReview(Review review) {
		if (rCount < MAX_REVIEW_SIZE) {
			reviews[rCount++] = review;
			return true;
		}
		return false;
	}
	
	public boolean removeReview (int reviewId) {
		for (int i = 0; i < pCount; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[rCount-1]; // 마지막 상품을 지우고 싶은 자리에 추가
				reviews[pCount-1] = rNull; // 마지막 상품 지움
				rCount -= 1;
				return true;
			}
		}
		return false;
	}
	
	public Review[] getProductReview (String pCode) {
		
		
		int rTempSize = 0;
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getpCode() == pCode) {
				rTempSize++;
			}
		}
		Review[] tempReviews = new Review[rTempSize];
		int rIdx = 0;
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getpCode() == pCode) {
				tempReviews[rIdx++] = reviews[i];
			}
		}
		return tempReviews;
 	}
}
 