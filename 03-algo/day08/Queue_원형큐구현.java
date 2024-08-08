import java.util.Arrays;

public class Queue_원형큐구현 {

	// 데이터를 3개 담을수 있다
	static String[] queue = new String[4];
	static int front, rear;
	static int N = queue.length;
	static int size;

	public static void main(String[] args) {

		enQueue("루나");
		enQueue("데이지");
		enQueue("맥스");
		enQueue("서울9반강기훈");
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		enQueue("서울9반강기훈");
		enQueue("서울8반소남주");
		enQueue("서울10반지유림");
		System.out.println(size());
		System.out.println(Arrays.toString(queue));

	}

	// 포화상태 확인
	static boolean isFull() {
		return (N + front - rear) % N == 1;
	}

	// 공백상태 확인
	static boolean isEmpty() {
		return front == rear;
	}

	// 삽입
	static void enQueue(String data) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		size++;
		rear = (rear + 1) % N;
		queue[rear] = data;
	}

	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		size--;
		front = (front + 1) % N;
		String item = queue[front];
		queue[front] = null;
		return item;
	}

	// 조회
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[(front + 1) % N];
	}

	// 데이터 개수
	static int size() {
		return (N + rear - front) % N;
	}

}
