#!/bin/bash
## Install necessary libs
apt install zip unzip git build-essential -y
## Install sdkman & tools
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 25.0.1-tem
sdk install scalacli 1.12.0
## Install jextract
cd /opt/
curl -LO https://download.java.net/java/early_access/jextract/25/2/openjdk-25-jextract+2-4_linux-x64_bin.tar.gz
tar -xzf openjdk-25-jextract+2-4_linux-x64_bin.tar.gz
## Setup project
cd ~/native-method-call-playground/
javac -h native/ src/main/java/methods/JNIPowerCalculator.java
mkdir lib
gcc -shared -fPIC  -I"$JAVA_HOME/include"  -I"$JAVA_HOME/include/linux"  native/PowerCalculator.c -o lib/libnative-power-calculator.so -lm
/opt/jextract-25/bin/jextract --output src/main/java -t math /usr/include/math.h --header-class-name NativeMath  --include-function pow