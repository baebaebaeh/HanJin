package com.ssafy.ws.day06.step04;

/**
 * 맛집 객체를 생성하고 정보를 출력하는 클래스
 */
public class RestaurantTest {
	public static void main(String[] args) {
		Restaurant r1 = new Restaurant(401, "도마29", "대구", "연어초밥", 8);
		Restaurant r2 = new Restaurant(301, "마포리", "서울", "마포리스테이크", 7);
		Restaurant r3 = new Restaurant(601, "성심당", "대전", "튀김소보로", 8);
		KoreanRestaurant k1 = new KoreanRestaurant(101, "을밀대", "서울", "물냉면", 9, "02-717-1922", "NO");
		KoreanRestaurant k2 = new KoreanRestaurant(102, "도꼭지", "서울", "도미솥밥", 9, "02-711-0432", "15:00 ~ 17:00");
		
		RestaurantManager rm = RestaurantManager.getInstance();
		rm.addRestaurant(r1);
		rm.addRestaurant(r2);
		rm.addRestaurant(r3);
		rm.addRestaurant(k1);
		rm.addRestaurant(k2);
		
		System.out.println("**************************한식 맛집 목록**************************");
		for (KoreanRestaurant a : rm.getKoreanRestaurantList())
			System.out.println(a);
		
		System.out.println("**************************브레이크 타임이 있는 목록**************************");
		for (KoreanRestaurant a : rm.getKoreanRestaurantList()) {
			if (!(a.getBreakTime().equals("NO")))
				System.out.println(a);
		}
		System.out.println("**************************일반 맛집 목록**************************");
		for (Restaurant a : rm.getNonkoreanRestaurants()) {
			System.out.println(a);
		}
	}
}
