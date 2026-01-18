package methods;

import java.lang.invoke.MethodHandle;
import java.lang.foreign.*;

public class PanamaPowerCalculator {
    private static final MethodHandle METHOD_HANDLE;

    static {
        Linker linker = Linker.nativeLinker();
        MemorySegment symbol = linker.defaultLookup().find("pow").get();
        FunctionDescriptor fd = FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE);
        METHOD_HANDLE = linker.downcallHandle(symbol, fd);
    }

    public static double calculateInvokeExact(double base, double exponent) {
        try {
            return (double) METHOD_HANDLE.invokeExact(base, exponent);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static double calculateInvoke(double base, double exponent) {
        try {
            return (double) METHOD_HANDLE.invoke(base, exponent);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}