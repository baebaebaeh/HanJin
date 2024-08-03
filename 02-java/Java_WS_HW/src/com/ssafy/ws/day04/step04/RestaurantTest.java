package com.ssafy.ws.day04.step04;

/**
 * 맛집 객체를 생성하고 정보를 출력하는 클래스
 */
public class RestaurantTest {
	public static void main(String[] args) {
		System.out.println("**************************************맛집목록**************************************");
		
		Restaurant rst1 = new Restaurant (101, "을밀대", 
				"서울", "냉면", 4);
		System.out.println(rst1.toString());
		
		Restaurant rst2 = new Restaurant (401, "도마29", 
				"대구", "연어초밥", 3);
		System.out.println(rst2.toString());
		
		System.out.println("**************************************리뷰목록**************************************");
		
		Review rev1 = new Review (1, 101, 
				"김싸피", "너무 맛있네요.");
		System.out.println(rev1.toString());
		
		Review rev2 = new Review (2, 401, 
				"나싸피", "연어초밥은 여기가 최고!");
		System.out.println(rev2.toString());
		
	}
}
