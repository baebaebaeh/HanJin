package com.ssafy.hw.day09.step04;


/**
 * 상품 객체를 생성하고 출력하는 클래스 
 *
 */
public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product("1", "냉장고", 100, 4, "samsung", "그냥");
		
		Review r1 = new Review(123, "1", "bae", "good");
		Review r2 = new Review(12, "1", "baehan", "good");
		
		IProductManager pm = ProductManagerImpl.getInstance();
		pm.addReview(r1);
		pm.addReview(r2);
		
		pm.addProduct(p1);
		
		try {
			for(Review a : pm.getProductReview("1"))
			System.out.println(a);
		} catch (ReviewNotFoundException e) {
			e.printStackTrace();
		}
		
//		try {
//			pm.sell("2", 10);
//		} catch (QuantityException e) {
//			e.printStackTrace();
//		} catch (ProductCodeNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
