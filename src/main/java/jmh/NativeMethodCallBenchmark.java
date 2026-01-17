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

    private StatefulPowerCalculator statefulPowerCalculator;

    @Setup
    public void setup() {
        statefulPowerCalculator = new StatefulPowerCalculator(2.0, 10.0);
    }

    @Benchmark
    public void benchmark_JNI_Stateless_Power_Calculator(Blackhole bh) {
        bh.consume(StatelessPowerCalculator.calculate(2.0, 10.0));
    }

    @Benchmark
    public void benchmark_JNI_Stateful_Power_Calculator(Blackhole bh) {
        bh.consume(statefulPowerCalculator.calculate());
    }

    @Benchmark
    public void benchmark_Math_Power_Calculator(Blackhole bh) {
        bh.consume(MathPowerCalculator.calculate(2.0, 10.0));
    }

    @Benchmark
    public void benchmark_Strict_Math_Power_Calculator(Blackhole bh) {
        bh.consume(StrictMathPowerCalculator.calculate(2.0, 10.0));
    }
}