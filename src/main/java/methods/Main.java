package methods;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // warmup runs
        System.out.println("JNI Result: " + runJNIPowerCalculator());
        System.out.println("Panama Invoke Exact Result: " + runPanamaInvokeExactPowerCalculator());
        System.out.println("Panama Invoke With Conversion Result: " + runPanamaInvokeWithConversionPowerCalculator());
        System.out.println("Panama Invoke Without Conversion Result: " + runPanamaInvokeWithoutConversionPowerCalculator());
        System.out.println("Panama JExtract Result: " + runPanamaJExtractPowerCalculator());
        System.out.println("JNI Result: " + runJNIPowerCalculator());
        System.out.println("Panama Invoke Exact Result: " + runPanamaInvokeExactPowerCalculator());
        System.out.println("Panama Invoke With Conversion Result: " + runPanamaInvokeWithConversionPowerCalculator());
        System.out.println("Panama Invoke Without Conversion Result: " + runPanamaInvokeWithoutConversionPowerCalculator());
        System.out.println("Panama JExtract Result: " + runPanamaJExtractPowerCalculator());
        // fully optimized runs
        System.out.println("--------------------------------------------")
        System.out.println("JNI Result: " + runJNIPowerCalculator());
        System.out.println("Panama Invoke Exact Result: " + runPanamaInvokeExactPowerCalculator());
        System.out.println("Panama Invoke With Conversion Result: " + runPanamaInvokeWithConversionPowerCalculator());
        System.out.println("Panama Invoke Without Conversion Result: " + runPanamaInvokeWithoutConversionPowerCalculator());
        System.out.println("Panama JExtract Result: " + runPanamaJExtractPowerCalculator());
        Thread.sleep(60000);
    }

    private static long runJNIPowerCalculator() {
        var result = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            result += JNIPowerCalculator.calculate((double) i, 2.0);
        }
        return result;
    }

    private static long runPanamaInvokeExactPowerCalculator() {
        var result = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            result += PanamaPowerCalculator.calculateInvokeExact((double) i, 2.0);
        }
        return result;
    }

    private static long runPanamaInvokeWithConversionPowerCalculator() {
        var result = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            result += PanamaPowerCalculator.calculateInvokeWithConversion(i, 2);
        }
        return result;
    }

    private static long runPanamaInvokeWithoutConversionPowerCalculator() {
        var result = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            result += PanamaPowerCalculator.calculateInvokeWithoutConversion((double) i, 2.0);
        }
        return result;
    }

    private static long runPanamaJExtractPowerCalculator() {
        var result = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            result += PanamaJExtractPowerCalculator.calculate((double) i, 2.0);
        }
        return result;
    }
}