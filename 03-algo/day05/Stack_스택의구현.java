import java.util.Stack;

public class Stack_스택의구현 {

	static String[] stack = new String[100];
	// 마지막에 들어간 데이터의 index를 가리키는 top
	static int top = -1;

	public static void main(String[] args) {
//		Stack<String> stack = new Stack<>();
//	
//		stack.push("고양이");
//		stack.push("토끼");
//		stack.push("쥐");
//		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(stack.pop());
//		}

		push("고양이");
		push("토끼");
		push("쥐");

		while (!isEmpty()) {
			String popItem = pop();
			System.out.println(popItem);
		}
		
//		for (int i = 0; i <= 100; i++) {
//			push(i + "");
//		}
		
		

	}

	static boolean isEmpty() {
//		if (top == -1) {
//			return true;
//		} 
//		return false;
		return top == -1;
	}

	static boolean isFull() {
		return top == stack.length - 1;
	}

	static void push(String item) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = item;
	}

	static String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}

//		pop한 위치를 지워주는 코드

//		String popItem = stack[top];
//		stack[top--] = null;
//		return popItem;

		return stack[top--];
	}

	static String peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}
