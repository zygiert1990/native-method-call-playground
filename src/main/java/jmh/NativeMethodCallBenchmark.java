package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import methods.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(3)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class NativeMethodCallBenchmark {

    @Benchmark
    public void benchmark_JNI_Power_Calculator(Blackhole bh) {
        bh.consume(JNIPowerCalculator.calculate(2.0, 10.0));
    }

    @Benchmark
    public void benchmark_Math_Power_Calculator(Blackhole bh) {
        bh.consume(MathPowerCalculator.calculate(2.0, 10.0));
    }

    @Benchmark
    public void benchmark_Panama_Invoke_Exact_Power_Calculator(Blackhole bh) {
        bh.consume(PanamaPowerCalculator.calculateInvokeExact(2.0, 10.0));
    }

    @Benchmark
    public void benchmark_Panama_Invoke_Power_Calculator(Blackhole bh) {
        bh.consume(PanamaPowerCalculator.calculateInvoke(2.0, 10.0));
    }
}