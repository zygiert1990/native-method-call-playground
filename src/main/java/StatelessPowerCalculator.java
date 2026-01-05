public class StatelessPowerCalculator {
    static {
        System.loadLibrary("native-power-calculator");
    }

    public static native double calculate(double base, double exponent);
}