package com.ssafy.hw.day09.step04;

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
	private static int reviewNo;

	private ProductManagerImpl() {}
	private static IProductManager instance = new ProductManagerImpl();
	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
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
	public int sell(String pCode, int cnt) throws QuantityException, ProductCodeNotFoundException {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode() == pCode) {
				if (products.get(i).getQuantity() >= cnt) {
					products.get(i).setQuantity(products.get(i).getQuantity()-cnt);
					return products.get(i).getQuantity()-cnt;					
				}
				throw new QuantityException();
			}
		}
		throw new ProductCodeNotFoundException(pCode);
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
	public Product searchByCode(String pCode) throws ProductCodeNotFoundException {
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
		} else {
			List<Review> reviewList = new ArrayList<>();
			reviewList.add(review);
			reviews.put(review.getpCode(), reviewList);
		}
//		List<Review> pReviews = new ArrayList<Review>();
//		for (int i = 0; i < )
//		if (reviews.keySet()[i])
//		reviews.put(review.getpCode(), List<review>);
		return false;
	}

	@Override
	public List<Review> getProductReview(String pCode) throws ReviewNotFoundException {
		if (reviews.containsKey(pCode)) {
			return reviews.get(pCode);			
		}
		throw new ReviewNotFoundException(pCode);
	}

	@Override
	public Product[] searchByName(String name) throws NameNotFoundException {
		int pSize = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpName().contains(name)) {
				pSize++;
			}
		}
		if (pSize == 0) {
			throw new NameNotFoundException(name);
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
	public long getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public Product[] getRefrigerators() {
		int pSize = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				pSize++;
			}
		}
		Product[] temp = new Product[pSize];
		int idx = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				temp[idx++] = products.get(i);
			}
		}
		return temp;
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		return null;
		// TODO Auto-generated method stub
	}
}
