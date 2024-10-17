package battlessafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static String[][] mapData; // 맵 정보
	private static Map<String, String[]> allies = new HashMap<>(); // 아군 정보
	private static Map<String, String[]> enemies = new HashMap<>(); // 적군 정보
	private static String[] codes; // 암호문 정보

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		mapData = new String[16][16];
		for (int i = 0; i < 16; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 16; j++) {
				mapData[i][j] = st.nextToken();
			}
		}
		bfs(0, 0);
	}

//	----- 여기부터 내  코드 작성
	// U D L R
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean visited[][];

	private static int[] bfs(int x, int y) {
		int N = mapData.length;
		visited = new boolean[N][N];
		Queue<int[]> qu = new LinkedList<>();

		// (현재 위치 x,y, 바로 다음에 선택할 위치 ,0,0, 이동 횟수}
		qu.add(new int[] { x, y, -2, -2, 0 });

		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			System.out.println("poll했음 : " + curr[0] + " , " + curr[1]);

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < N && nc < N && nr >= 0 && nc >= 0 && mapData[nr][nc].equals("X")) {
					System.out.println("nextStep = " + curr[3] + " + " + curr[4]);
					return new int[] { curr[3], curr[4] };

				}

				// 넘어가거나 이미 갔거나 잔디가 아니라면 안 갈거니까 건너뛰기
				if (nr >= N || nc >= N || nr < 0 || nc < 0) {
//					System.out.println(d + " 보드를 넘어갔어, 안 가");
					continue;
				}

				if (visited[nr][nc]) {
//					System.out.println(d + " 이미 방문했어, 안 가");
					continue;
				}
//				if (!mapData[nr][nc].equals("G")) {
//					System.out.println(d + " 풀이 아냐, 안 가");
//					continue;
//				}
				if (mapData[nr][nc].equals("R") || mapData[nr][nc].equals("W") || mapData[nr][nc].equals("T")
						|| mapData[nr][nc].equals("H")) {
//					System.out.println(d + " 풀이 아냐, 안 가");
					continue;
				}

				// 만약 지금이 딱 첫 발자국이라면 그 발자국을 파라미터로 기억하기
				if (curr[4] == 0) {
//					System.out.println("첫발자국!" + nr + " + " + nc);
					qu.add(new int[] { nr, nc, nr, nc, 1 });
				} else {
					// 첫 발자국이 아니라면 그 전꺼를 그대로 기억하기
					qu.add(new int[] { nr, nc, curr[2], curr[3], curr[4] + 1 });
//					System.out.println(nr+" + " + nc +"큐에 추가!");

				}
			}
		}
		return null;

	}
	

	// ----- 여기까지가 내 코드
	// 입력 데이터를 파싱하여 변수에 저장
	static void parseData(String gameData) {
		// 입력 데이터를 행으로 나누기
		String[] rows = gameData.split("\n");
		int rowIndex = 0;

		// 첫 번째 행 데이터 읽기
		String[] header = rows[rowIndex].split(" ");
		int mapHeight = Integer.parseInt(header[0]); // 맵의 세로 크기
		int mapWidth = Integer.parseInt(header[1]); // 맵의 가로 크기
		int numOfAllies = Integer.parseInt(header[2]); // 아군의 수
		int numOfEnemies = Integer.parseInt(header[3]); // 적군의 수
		int numOfCodes = Integer.parseInt(header[4]); // 암호문의 수
		rowIndex++;

		// 기존의 맵 정보를 초기화하고 다시 읽어오기
		mapData = new String[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			mapData[i] = rows[rowIndex + i].split(" ");
		}
		rowIndex += mapHeight;

		// 기존의 아군 정보를 초기화하고 다시 읽어오기
		allies.clear();
		for (int i = 0; i < numOfAllies; i++) {
			String[] allyData = rows[rowIndex + i].split(" ");
			String allyName = allyData[0];
			String[] allyInfo = Arrays.copyOfRange(allyData, 1, allyData.length);
			allies.put(allyName, allyInfo);
		}
		rowIndex += numOfAllies;

		// 기존의 적군 정보를 초기화하고 다시 읽어오기
		enemies.clear();
		for (int i = 0; i < numOfEnemies; i++) {
			String[] enemyData = rows[rowIndex + i].split(" ");
			String enemyName = enemyData[0];
			String[] enemyInfo = Arrays.copyOfRange(enemyData, 1, enemyData.length);
			enemies.put(enemyName, enemyInfo);
		}
		rowIndex += numOfEnemies;

		// 기존의 암호문 정보를 초기화하고 다시 읽어오기
		codes = new String[numOfCodes];
		for (int i = 0; i < numOfCodes; i++) {
			codes[i] = rows[rowIndex + i];
		}
	}
}
