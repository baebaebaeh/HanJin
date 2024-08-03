package test06_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		// Deque
		// deque는 인터페이스다
		// 구현체 : Arraydeque linkedlist
		// 양쪽끝에서 자유롭게 자료의 추가 삭제 가능
		
		// 객체배열관리 실습 : array <= 실제로 배열을 가지고 리스트를 만들어 본 것임
		// 중간에 삭제, 중간에 추가... 이거 너무 골칫거리
		// 중간에서 삭제ㅐ 추가가 빈번하게 일어나는 상황에 LinkedList가 사용됨
		// array : 조회는 빠르다. 하지만 삭제추가가 번거롭다
		// LinkedList : 조희는 느린데 삭제&추가는 빠르다.
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.addFirst("alice");
		deque.addFirst("luna");
		deque.addLast("max");
		deque.addFirst("dasiy");
		
		System.out.println(deque);
		// 출력 : [dasiy, luna, alice, max]

		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeFirst());
		
	}
}
