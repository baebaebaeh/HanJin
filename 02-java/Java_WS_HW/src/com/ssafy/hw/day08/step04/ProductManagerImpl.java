package com.ssafy.hw.day08.step04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManagerImpl implements IProductManager {
	private List<Product> products = new ArrayList<>();
	private Map<String, List<Review>> reviews = new HashMap<>();
	private static int reviewNo = 0;

	private ProductManagerImpl() {
	}

	private static IProductManager instance = new ProductManagerImpl();

	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == product.getpCode()) {
				return false;
			}
		}
		products.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == product.getpCode()) {
				products.remove(i);
				products.add(product);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeProduct(String pCode) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == pCode) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int sell(String pCode, int cnt) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == pCode) {
				products.get(i).setQuantity(products.get(i).getQuantity() - cnt);
				return products.get(i).getQuantity() - cnt;
			}
		}
		return -1;
	}

	@Override
	public Product[] getProductList() {
		int pSize = 0;
		for (int i = 0; i < products.size(); i++) {
			if (!(products.get(i) instanceof Refrigerator)) {
				pSize++;
			}
		}
		Product[] temp = new Product[pSize];
		int idx = 0;
		for (int i = 0; i < products.size(); i++) {
			if (!(products.get(i) instanceof Refrigerator)) {
				temp[idx++] = products.get(i);
			}
		}
		return temp;
	}

	@Override
	public Product searchByCode(String pCode) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == pCode) {
				return products.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean addReview(Review review) {
		if (reviews.containsKey(review.getpCode())) {
			reviews.get(review.getpCode()).add(review);
			return true;
		} else {
			List<Review> temp = new ArrayList<>();
			temp.add(review);
			reviews.put(review.getpCode(), temp);

		}
		return false;
	}

	@Override
	public boolean removeReview(Review review) {
		for (int i = 0; i < reviews.get(review.getpCode()).size(); i++) {
			if (reviews.get(review.getpCode()).get(i).getReviewId() == review.getReviewId()) {
				reviews.get(review.getpCode()).remove(i);
			}
		}
		return false;
	}

	@Override
	public List<Review> getProductReview(String pCode) {
		return reviews.get(pCode);
	}

	@Override
	public Product[] searchByName(String name) {
		int pSize = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpName().contains(name)) {
				pSize++;
			}
		}
		Product[] temp = new Product[pSize];
		int idx = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpName().contains(name)) {
				temp[idx++] = products.get(i);
			}
		}
		return temp;
	}

	@Override
	public long getTotlPrice() {
		long sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Refrigerator[] getRefrigerators() {
		int rSize = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				rSize++;
			}
		}
		Refrigerator[] temp = new Refrigerator[rSize];
		int idx = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				temp[idx++] = (Refrigerator) products.get(i);
			}
		}
		return temp;
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		// TODO Auto-generated method stub
		return null;
	}
	// 코드를 작성하세요.
}
