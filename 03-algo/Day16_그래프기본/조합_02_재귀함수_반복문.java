import java.util.Arrays;

public class 조합_02_재귀함수_반복문 {
	static String[] 재료 = { "상추", "패티", "토마토", "치즈" };
	static int N, R; // N : 재료의 수, R : 내가 뽑고 싶은 재료의 수
	static String[] sel; // 뽑은 재료들을 저장할 배열

	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		
		combination(0, 0);
		
	}
	
	//서울5반 김지승 1등
	public static void combination(int idx, int sidx) {
		if(sidx == R) {
			//모든 재료를 전부다 뽑았다!
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i = idx; i <N; i++) {
			sel[sidx] = 재료[i]; //뽑았어요~~
			combination(i, sidx+1);
		}
		
		
	}
}
