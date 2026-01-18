## Environment

`Intel(R) Xeon(R) @ 2.20GHz - 4 vCPU (2 cores), 16GB RAM, Debian GNU/Linux 12 (bookworm)`

`OpenJDK Runtime Environment Temurin-25.0.1+8 (build 25.0.1+8-LTS)`

`SDKMAN!
script: 5.20.0
native: 0.7.14 (linux x86_64)`

`Scala CLI version: 1.12.0`

## Warning!

Project does not compile before generating helper class with `jextract`.

## Prerequisites

You can either follow all the steps manually or initialize the environment using [init-script](scripts/init.sh):
1. `git clone https://github.com/zygiert1990/native-method-call-playground.git`
2. `cd native-method-call-playground/`
3. `chmod +x scripts/init.sh`
4. `./scripts/init.sh`

## Manual steps

For compiling `libnative-power-calculator.so` you need `gcc` installed: `apt install build-essential`

To use `jextract`:
- `cd /opt/`
- find proper url on [jextract](https://jdk.java.net/jextract/) - then `curl -LO <proper_url>`
- `tar -xzf openjdk-25-jextract+2-4_linux-x64_bin.tar.gz` (file name might differ, depends on downloaded archive)

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

## Generate `NativeMath` helper class

1. Generate using `jextarct` - [math_h.java](.files/NativeMath.java):
```
/opt/jextract-25/bin/jextract --output src/main/java \
-t math \
/usr/include/math.h \
--header-class-name NativeMath \
--include-function pow
```

## Run Main Class
`scala-cli . --main-class methods.Main --power`

## Run JMH Benchmark
`scala-cli . --jmh --power`