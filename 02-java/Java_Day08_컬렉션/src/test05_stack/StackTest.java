package test05_stack;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		// 인터페이스의 분리
		// -- 구현체가 달라질 수 있따.
		
		
		
		
		//Stack이란
		//  단일클래스
		//  LIFO
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.add(2);
		stack.push(3);
		
		//선입후출 확인
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		
		stack.peek(); // pop과는 ㄴ다르게 값을 꺼내는것이 아니라 조회만 한다.
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		//333
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
