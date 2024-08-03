package test06_delete_method;

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public void speak() {
        System.out.println("동물이 소리를 냅니다");
        // 쓰이지 않는 코드.
    }
    // 만약 쓰이지 않는다고 해서 삭제를 하게 되면
    // 1. 자식에서 오버라이드 불가
    // 2. 참조형 변수에서 참조 불가.
    //    (해당 참조에 클래스에 정의되어 있는 것만 보이므로)
    

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