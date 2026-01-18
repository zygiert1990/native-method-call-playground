package methods;

public class Main {
    public static void main(String[] args) {
        System.out.println("JNI Result: " + JNIPowerCalculator.calculate(2, 10));
        System.out.println("Panama Invoke Exact Result: " + PanamaPowerCalculator.calculateInvokeExact(2.0, 10.0));
        System.out.println("Panama Invoke Result: " + PanamaPowerCalculator.calculateInvoke(2, 10));
    }
}