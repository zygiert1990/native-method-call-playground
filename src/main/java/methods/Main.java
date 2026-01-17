package methods;

public class Main {
    public static void main(String[] args) {
        System.out.println("Static Result: " + StatelessPowerCalculator.calculate(2, 10));

        System.out.println("Instance Result: " + new StatefulPowerCalculator(2, 10).calculate());
    }
}