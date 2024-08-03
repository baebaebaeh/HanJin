package test02_type_casting;

public class Test {
    public static void main(String[] args) {
    	// 참조형 변수의 형 변환
    	// 1. 묵시적 형변환: 자손 타입 => 조상 타입 
    	Person p = new Student(); // 자식객체 -> 부모
    	
    	// 2. 명시적 형변환: 조상 타입 => 자손 타입
    	//  - 형 변환 연산자 사용
    	// Student st = (Student) new Person(); // 되는 것처럼 보이는데.. 
    	// 될까? => 안된다!  java.lang.ClassCastException:
    	// 컴파일은 되었지만 실행 중에 에러 발생
    	// 컴파일: 문법적 오류만 검사!
    	
    	// 명시적 형변환인데 에러가 안나는 경우
    	// - 자손 객체를 만든다음에 부모 클래스로 형변환 했다가,
    	//   다시 돌아오는 경우.
    	
//    	Student st = (Student) p;
    	
    	// 다형성을 이용하는 대표적 사례 : 객체배열관리
    	Person[] persons = new Person[3];
    	
    	persons[0] = new Person("Park", 27);
    	persons[1] = new Student("Kim", 22, "Java");
    	persons[2] = new Student("Lee", 29, "Java");
    	
    	for(Person person : persons) {
//    		System.out.println(person);
//    		person.eat();
    		
    		// 만약 Student인 객체만 출력하고 싶다면?
//    		if(person instanceof Student) {
//    			// 이 안에서는 예외의 걱정없이 안전하게
//    			// Student와 관련된 메서드 사용 가능.
//    			// 이 안에서는 안전하게 형변환이 가능하다.
//    			System.out.println(person);
//    			((Student)person).study();
//    		}
    		// Person 하나만 출력하고 싶으면?
    		// Student가 아닌 Person을 출력하고 싶으면?
    		if(!(person instanceof Student)) {
    			System.out.println(person);
    		}
    	}
    	
    	// instanceof 연산자
    	// 객체(변수) instanceof 클래스이름
    	// - 해당 클래스로 묵시적 형변환이 가능하다면 true
    	// -                       불가하다면 false
    	// A instanceof B
    	// - (상속관계에서) A는 B이다가 성립할 때 true
    	// - 사람은 사람이다 ok => true
    	// - 학생은 사람이다 ok => true
    	// - 사람은 학생이다 x  => false
    	// - 해당 방향으로 에러없이 형변환이 가능한 경우 true
    	
    	
    	
    	
    			

        
    }
}










