package day_250325.method;

public class MainMathClass {
    public static void main(String[] args) {
        MathClass m = new MathClass();
        int result = m.sumNumbers(0, 100);
        System.out.println("총합 : " + result);
    }
}
