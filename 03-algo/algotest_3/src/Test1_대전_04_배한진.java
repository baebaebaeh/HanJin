import java.io.*;

public class Test1_대전_04_배한진 {
	static long[] dp;
	static int[] step;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= testCase; TC++) {
			int H = Integer.parseInt(br.readLine());
			dp = new long[H + 1];
			// 처음 dp를 1로 맞춤
			dp[0] = 1;
			// 고양이 스탭배열 생성
			step = new int[3];
			step[0] = 1;
			step[1] = 3;
			step[2] = 4;
			// 현재높이가 i일때 최적해 구하기
			for (int i = 0; i <= H; i++) {
				// 모든 고양이스탭을 고려하기
				for (int j = 0; j < 3; j++) {
					if (i >= step[j]) {
						// 이전 최적해 불러오기
						long prev = dp[i - step[j]];
						// 현재값에 넣어주기
						dp[i] += prev;
					}
				}
			}
			bw.write(("#" + TC + " " + dp[H] + "\n"));
		}
		bw.flush();
	}
}
