package kokoJunit;

public class MathUtils {


    public int add(int a, int b) {
        return a + b;
    }

    public double calculateAreaofaCircleChecker(int radius) {

        return (radius * radius) * 3.14;
    }

    public int divide(int divisor, int divider) {
        return divisor/divider;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        MathUtils mu = new MathUtils();
        System.out.println(mu.add(2,3));
    }


}
