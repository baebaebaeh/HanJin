package java03_operator;

public class Op02_산술연산자 {
    public static void main(String[] args) {
        int a = 10;
        int b = 6;
        
        System.out.println(a + b); // 16
        System.out.println(a - b); // 4 
        System.out.println(a * b); // 60
        System.out.println(a / b); // 1 : 둘다 정수형이기 때문에 정수형으로 출력이 된다.
        System.out.println(a % b); // 4
        
        System.out.println((double)a / b);
        System.out.println(a / (double)b);
        System.out.println((double)(a / b));
        
        System.out.println(13.4f / 20L);
        
        double c = 2.3;
        
        System.out.println(a / c);
        System.out.println(a / (int) c);
        
        // 둘 다 정수 => 계산 결과도 정수 (소수점 이하 버림) 
        // 둘 중 하나라도 실수 => 계산 결과는 실수
        
    }
}
