## Environment

`Intel(R) Xeon(R) @ 2.20GHz - 4 vCPU (2 cores), 16GB RAM, Debian GNU/Linux 12 (bookworm)`

`OpenJDK Runtime Environment Temurin-25.0.1+8 (build 25.0.1+8-LTS)`

`SDKMAN!
script: 5.20.0
native: 0.7.14 (linux x86_64)`

`Scala CLI version: 1.12.0`

## Compile `libnative-power-calculator.so`

1. Generate header file: `javac -h native/ src/main/java/methods/JNIPowerCalculator.java`
2. In project `root` directory create `lib` dir: `mkdir lib`
3. Compile a native library (I was using `sdkman` to install `java`):
```
gcc -shared -fPIC \
 -I"$JAVA_HOME/include" \
 -I"$JAVA_HOME/include/linux" \
 native/PowerCalculator.c -o lib/libnative-power-calculator.so -lm
```

## Run Main Class
`scala-cli . --main-class methods.Main --power`

## Run JMH Benchmark
`scala-cli . --jmh --power`