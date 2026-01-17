package methods;

public class StatefulPowerCalculator {
    static {
        System.loadLibrary("native-power-calculator");
    }

    private final double base;
    private final double exponent;

    public StatefulPowerCalculator(double base, double exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public native double calculate();
}