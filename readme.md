## Environment

`Intel(R) Xeon(R) @ 2.20GHz - 4 vCPU (2 cores), 16GB RAM, Debian GNU/Linux 12 (bookworm)`

## Compile `libnative-power-calculator.so`

1. Generate header files: `javac -h native/ src/main/java/StatefulPowerCalculator.java src/main/java/StatelessPowerCalculator.java`
2. In project `root` directory create `lib` dir: `mkdir lib`
3. Compile a native library (I was using `sdkman` to install `java`):
```
gcc -shared -fPIC \
 -I"$(sdk home java $(sdk current java | awk '{print $NF}'))/include" \
 -I"$(sdk home java $(sdk current java | awk '{print $NF}'))/include/linux" \
 native/PowerCalculator.c -o lib/libnative-power-calculator.so -lm
```