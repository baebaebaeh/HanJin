
public class Array08_2차원배열실습 {
	public static void main(String[] args) {
	    int[][] grid = {
                {2, 3, 1, 4, 7},
                {8, 13, 3, 33, 1},
                {7, 4, 5, 80, 12},
                {17, 9, 11, 5, 4},
                {4, 5, 91, 27, 7}
	    };
	    
	    int sum = 0; // 합 저장 변수
	    int cnt = 0; // 개수 저장 변수
	    for(int r=0; r<grid.length; r++) { // grid.length 2차원 배열의 길이.
	    	for(int c=0; c<grid[r].length; c++) { // grid[r].length 1차원 배열의 길이
	    		
	    		if(grid[r][c] % 3 == 0){ // 3의 배수면 뭔가를 하겠다. <=> 3의 배수가 아니면 건너뛰겠다.
	    			sum += grid[r][c];
	    			cnt++;
	    		}
	    		
	    	}
	    }
	    
	    System.out.println(sum);
	    System.out.println(cnt);
	    
	    sum = 0; // 합 저장 변수
	    cnt = 0; // 개수 저장 변수
	    out: for(int r=0; r<grid.length; r++) { // grid.length 2차원 배열의 길이.
	    	for(int c=0; c<grid[r].length; c++) { // grid[r].length 1차원 배열의 길이
	    		
	    		if(grid[r][c] % 3 != 0) continue out;
	    		
	    		System.out.println(r+","+c);
	    		// continue: (r, c) = (2, 2) => (2, 3)
	    		// continue out:      (2, 2) => (3, 0)
	    		
	    		// continue;는 해당 반복문 안에서 continue 밑에 내용을 수행하지 않고
	    		// 바로 다음 반복으로 넘어간다.
	    		
	    		// break
	    		// 해당 반복을 종료.
	    		
	    		
	    		sum += grid[r][c];
	    		cnt++;
	    		
	    		
	    	}
	    }
	    
	    System.out.println(sum);
	    System.out.println(cnt);
	    
	    
	}
}
