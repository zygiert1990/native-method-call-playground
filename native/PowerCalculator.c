#include <jni.h>
#include <math.h>
#include "methods_JNIPowerCalculator.h"

JNIEXPORT jdouble JNICALL Java_methods_JNIPowerCalculator_calculate
  (JNIEnv *env, jclass clazz, jdouble base, jdouble exponent) {
    return pow(base, exponent);
}