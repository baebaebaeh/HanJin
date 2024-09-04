import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	// 추가적인 공간 필요
	// 대전 3반 김형표 명예!
	static int[] result;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 1 };
		N = nums.length;
		result = new int[N];
		perm(0, 0);
		
		//결과를 모아서 보려고 했을때 잘 해야한다. 이슈가 생길수 있음.
		for(int[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		
		
	}// main
		// idx : 현재 판단 위치

	// idx : 결과 배열에 저장할 위치
	// visited : 사용한 원소를 기록하기 위한 정수
	static void perm(int idx, int visited) {
		// 기저조건
//		if(visited == (1<<N)-1) return; 이것도 좋아.
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			//이런식으로 담으면 이상해요.
			list.add(result);
			return;
		}
		// 재귀부분
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0)
				continue;

			result[idx] = nums[i];
			perm(idx + 1, visited | (1 << i)); // 다음 자리 판단.

		}

	}

}
