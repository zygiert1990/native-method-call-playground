package methods;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("JNI Result: " + runJNIPowerCalculator());
        System.out.println("Panama Invoke Exact Result: " + runPanamaInvokeExactPowerCalculator());
        System.out.println("Panama Invoke Result: " + runPanamaInvokePowerCalculator());
        System.out.println("Panama JExtract Result: " + runPanamaJExtractPowerCalculator());
        System.out.println("JNI Result: " + runJNIPowerCalculator());
        System.out.println("Panama Invoke Exact Result: " + runPanamaInvokeExactPowerCalculator());
        System.out.println("Panama Invoke Result: " + runPanamaInvokePowerCalculator());
        System.out.println("Panama JExtract Result: " + runPanamaJExtractPowerCalculator());
        Thread.sleep(60000);
    }

    private static long runJNIPowerCalculator() {
        var result = 0L;
        for (int i =0; i < 1_000_000; i++) {
            result += JNIPowerCalculator.calculate(2, 10);
        }
        return result;
    }

    private static long runPanamaInvokeExactPowerCalculator() {
        var result = 0L;
        for (int i =0; i < 1_000_000; i++) {
            result += PanamaPowerCalculator.calculateInvokeExact(2, 10);
        }
        return result;
    }

    private static long runPanamaInvokePowerCalculator() {
        var result = 0L;
        for (int i =0; i < 1_000_000; i++) {
            result += PanamaPowerCalculator.calculateInvoke(2, 10);
        }
        return result;
    }

    private static long runPanamaJExtractPowerCalculator() {
        var result = 0L;
        for (int i =0; i < 1_000_000; i++) {
            result += PanamaJExtractPowerCalculator.calculate(2, 10);
        }
        return result;
    }
}