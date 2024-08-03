package test06_delete_method;
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("개가 말합니다: 멍멍");
    }
}