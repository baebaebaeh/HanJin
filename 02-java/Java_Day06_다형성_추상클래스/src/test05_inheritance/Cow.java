package test05_inheritance;
class Cow extends Animal {
    public Cow(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("소가 말합니다: 음매");
    }
}
