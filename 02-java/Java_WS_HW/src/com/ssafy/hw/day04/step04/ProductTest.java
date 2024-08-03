package com.ssafy.hw.day04.step04;

/**
 * 상품 객체를 생성하고 출력하는 클래스 
 *
 */
public class ProductTest {

	public static void main(String[] args) {
		Product product1 = new Product("R00001", "S냉장고", 1000000, 20, "삼성", "삼성에서 출시한 스마트냉장고입니다.");
		Product product2 = new Product("R00001", "우주폰S", 500000, 100, "삼성", "삼성에서 출시한 우주폰S입니다.");
		Review review1 = new Review(1,"P00001","yang","성능이 아주 좋습니다~!");
		System.out.println("************************제품목록************************");
		System.out.println(product1.toString());
		System.out.println(product2.toString());
		System.out.println("************************리뷰내용************************");
		System.out.println(review1.toString());
	}
}

