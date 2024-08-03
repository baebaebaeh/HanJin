package test04_queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MapTes {
	public static void main(String[] args) {
		//Queue
		// FIFO
		//Queu인터페이스
		//LinkedList를 구현체로 사용
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 값을 추가
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		// queue.offer() queue.add() 는 둘다 똑같은 기능을 갖지고 있다.
		// 예외처리와 관련해서 차이가 있을 수 잇다.
		
		//값을 하나씩 꺼내기
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
		
		while (!queue.isEmpty()) { //큐가 비어있지 않으면
			System.out.println(queue.poll());
		}
		
		
	}
}
