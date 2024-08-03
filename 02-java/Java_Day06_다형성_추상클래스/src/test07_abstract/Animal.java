package test07_abstract;

// 추상 메서드를 하나라도 가지고 있다면
// 해당 클래스로는 객체 생성이 불가 => 추상 클래스로 만들어줘야
// 앞에 abstract 키워드를 붙여준다.
abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    // 쓰이지 않는 메서드를 아예 없앨 것이아니라
    // 추상 메서드로 만들 수 있다.
    // 추상 메서드 
    // - 본문이 없는 메서드
    // - abstract 키워드 명시
    // - 마지막에는 ;으로 끝낸다.
    public abstract void speak();


    public void eat() {
        System.out.println(name + "가 밥을 먹고 있습니다.");
    }

    // Getter와 Setter 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}