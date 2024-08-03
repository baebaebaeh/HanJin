package com.ssafy.ws.day06.step04;

import java.util.Arrays;

/**
 * 맛집, 리뷰 객체의 리스트를 배열로 유지하며 관리하는 클래스
 */
public class RestaurantManager {
	final private int MAX_RESTAURANT_SIZE = 100;
	final private int MAX_REVIEW_SIZE = 100;
	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int restaurantSize = 0;
	private int reviewSize = 0;
	
	private RestaurantManager() {}
	private static RestaurantManager instance = new RestaurantManager();
	public static RestaurantManager getInstance() {
		return instance;
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurants[restaurantSize++] = restaurant;
	}
	
	public void addReview(Review review) {
		reviews[reviewSize++] = review;
	}
	
	public void removeRestaurant(int resId) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				restaurants[i] = restaurants[--restaurantSize];
				restaurants[restaurantSize] = null;
			}
		}
	}
	
	public void removeComment(int reviewId) {
		for (int i = 0; i < reviewSize; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[--reviewSize];
				reviews[reviewSize] = null;
			}
		}
	}
	
	public KoreanRestaurant[] getKoreanRestaurantList() {
		int temp = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i] instanceof KoreanRestaurant) {
				temp++;
			}
		}
		int tempIdx = 0;
		KoreanRestaurant[] tempR = new KoreanRestaurant[temp];
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i] instanceof KoreanRestaurant) {
				tempR[tempIdx++] = (KoreanRestaurant) restaurants[i];
			}
		}
		return tempR;
	}
	
	
	public Restaurant[] getNonkoreanRestaurants() {
		int temp = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if (!(restaurants[i] instanceof KoreanRestaurant)) {
				temp++;
			}
		}
		int tempIdx = 0;
		Restaurant[] tempR = new Restaurant[temp];
		for (int i = 0; i < restaurantSize; i++) {
			if (!(restaurants[i] instanceof KoreanRestaurant)) {
				tempR[tempIdx++] = restaurants[i];
			}
		}
		return tempR;
	}
	
	public Restaurant[] getRestaurantList() {
		Restaurant[] tempRs = new Restaurant[restaurantSize];
		for (int i = 0; i < restaurantSize; i++) {
			tempRs[i] = restaurants[i];
		}
		return tempRs;
	}
	
	public Review[] getReviewList() {
		Review[] tempRs = new Review[reviewSize];
		for (int i = 0; i < restaurantSize; i++) {
			tempRs[i] = reviews[i];
		}
		return tempRs;
	}
	
	public Restaurant getRestaurant(int resId) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				return restaurants[i];
			}
		}
		return null;
	}
	
	public Review getReview(int reviewId) {
		for (int i = 0; i < reviewSize; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				return reviews[i];
			}
		}
		return null;
	}
}
