package com.ssafy.hw.day05.step04;

/**
 * 상품 객체를 생성하고 출력하는 클래스 
 *
 */
public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product("LG123", 
				"냉장고", 100000, 10, "LG", "매우쌈");
		Product p2 = new Product("SAMSUNG123", 
				"냉장고", 5000000, 9, "LG", "매우비쌈");
		Product p3 = new Product("SAMSUNG000", 
				"냉장고", 5000000, 9, "LG", "곧 단종됨");
		Review r1 = new Review(9954, "LG123", "한진",
				"자취방에서 쓰기 좋음.");
		Review r2 = new Review(7777, "SAMSUNG123", "카리나",
				"여럿이서 쓰기 좋음.");
		Review r3 = new Review(6666, "LG123", "닝닝",
				"자취방에서 쓰기 싫음.");
		Review r4 = new Review(5555, "SAMSUNG123", "윈터",
				"여럿이서 쓰기 싫음.");
		ProductManager pm = new ProductManager();
		
		pm.addProduct(p1);
		pm.addProduct(p2);
		pm.addProduct(p3);
		System.out.println("");
		for (Product a : pm.getProductList()) {
			System.out.println(a);			
		}
		
		
		pm.addReview(r1);
		pm.addReview(r2);
		pm.addReview(r3);
		pm.addReview(r4);
		System.out.println("");
		for (Review a : pm.getProductReview("SAMSUNG123")) {
			System.out.println(a);			
		}
		
		
		Product updateP1 = new Product("LG123", 
				"냉장고", 10000, 10, "LG", "최근 할인함");
		pm.updateProduct(updateP1);
		System.out.println("");
		for (Product a : pm.getProductList()) {
			System.out.println(a);			
		}
		
		
		pm.removeProduct("SAMSUNG000");
		System.out.println("");
		for (Product a : pm.getProductList()) {
			System.out.println(a);			
		}
		
		
		pm.sell("SAMSUNG123", 5);
		System.out.println("");
		for (Product a : pm.getProductList()) {
			System.out.println(a);			
		}
		
		System.out.println();
		System.out.println(pm.searchByCode("LG123"));
		
		System.out.println("");
		for (Review a : pm.getProductReview("LG123")) {
			System.out.println(a);			
		}
	}
}
