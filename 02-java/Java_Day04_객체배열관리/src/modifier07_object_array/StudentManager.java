package modifier07_object_array;

public class StudentManager {
	// Student의 배열을 가지고 있는 객체
	// => 1개의 객체만 생성하면 됨 => 싱글턴으로 만든다.
	
	Student[] arr = new Student[100]; // 빈 배열을 만들어 놓음, null로 초기화 되어 있는 상태
	int size = 0; // 실제 들어있는 개수.
	
	private StudentManager() {};
	private static StudentManager instance = new StudentManager();
	public static StudentManager getInstance() {
		return instance;
	}
	
	
	
	
	
	
	
	
	public void addStudent(Student st) {
		if(size < 100) {
			arr[size] = st;
			size++;
		} else {
			System.out.println("더 이상의 학생을 추가할 수 없습니다.");
		}
	}
	
	
    
}
