package com.ssafy.class1;

public class Test04_Condition {
	
	public static void main(String[] args) throws Exception {
		// 조건식 : if, switch
		// if (조건) : 조건이 참일 경우에만 실행
		/*
		 * if (조건) { 참일 경우 }
		 * else { 거짓일 경우 }
		 * 
		 * if (조건) { 참일 경우 }
		 * else if (조건) { 참일 경우 }
		 * else if (조건) { 참일 경우 }
		 * else { 위의 조건들을 만족하지 않는 모든것 }
		 */
		
		/*
		 * 수식자리에 들어온 값이 특정값과 같은지 판단
		 * 일치하는 case부터 break를 만날때까지 밑으로 내려가면서 수행
		 * 
		 * 수식자리에 올수 있는 것들
		 * 1.4버전 이하 : int로 자동 형변환 되는 타입들 가능(byte, short, int, char)
		 * 1.5버전 : enum 가능
		 * 1.7버전 : String 가능
		 * 
		 * switch (수식) {
		 * case 값1:
		 * 	
		 * case 값2:
		 * 
		 * case 값3:
		 * 
		 * default:
		 * }
		 * 
		 * 
		 * int no = 2;
		 * switch (no) {
		 * case 1:
		 * 	
		 * case 2:
		 * 
		 * case 3:
		 * 
		 * }
		 */
		
		{
			System.out.println("1.4버전 이전 체크");
//			double num = 3;  // 수식 자리 에러발생  
			int num = 1;  
			int result = 0;
			// Cannot switch on a value of type double. 
			// Only convertible int values, strings or enum variables are permitted
			switch (num) {  // byte, short, int, char
			case 1:
				result += 10;
				break;
			case 2:
				result += 20;
				break;
			case 3:
				result += 30;
				break;
			}
			System.out.println(result);
		}
		// 다른데 정의 되어 있는 값
		final String SEASON_SPRING = "spring";
		final String SEASON_SUMMER = "summer";
		final String SEASON_FALL = "fall";
		final String SEASON_WINTER = "winter";
		
		{
			System.out.println("1.7버전 - String 가능");
			String season = "spring";
			switch (season) {
			case SEASON_SPRING:
			case SEASON_SUMMER:
			case SEASON_FALL:
			case SEASON_WINTER:
			}
		}
		
		{
			System.out.println("1.5버전 - enum 가능");
			Season season = Season.SUMMER;
			switch (season) {
			case SPRING:
			case SUMMER:
			case FALL:
			case WINTER:
			}
		}
	}
	enum Season {
		SPRING, SUMMER, FALL, WINTER
	}
}














