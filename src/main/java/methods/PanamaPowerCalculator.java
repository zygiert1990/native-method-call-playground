package methods;

import java.lang.invoke.MethodHandle;
import java.lang.foreign.*;
import java.util.Map;

public class PanamaPowerCalculator {
    private static final MethodHandle METHOD_HANDLE;

    static {
        Linker linker = Linker.nativeLinker();
        Map<String, MemoryLayout> layouts = linker.canonicalLayouts();
        MemorySegment symbol = linker.defaultLookup().find("pow").get();
        ValueLayout cDouble = (ValueLayout) layouts.get("double");
        FunctionDescriptor fd = FunctionDescriptor.of(cDouble, cDouble, cDouble);
        METHOD_HANDLE = linker.downcallHandle(symbol, fd);
    }

    public static double calculateInvokeExact(double base, double exponent) {
        try {
            return (double) METHOD_HANDLE.invokeExact(base, exponent);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static double calculateInvoke(int base, int exponent) {
        try {
            return (double) METHOD_HANDLE.invoke(base, exponent);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}