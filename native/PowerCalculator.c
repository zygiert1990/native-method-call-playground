#include <jni.h>
#include <math.h>
#include "methods_StatefulPowerCalculator.h"
#include "methods_StatelessPowerCalculator.h"

jfieldID baseId;
jfieldID exponentId;

// This is called AUTOMATICALLY when System.loadLibrary is called
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if ((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_8) != JNI_OK) {
        return JNI_ERR;
    }

    // Find the class
    jclass cls = (*env)->FindClass(env, "methods/StatefulPowerCalculator");
    
    // Cache the IDs now, once and for all
    baseId = (*env)->GetFieldID(env, cls, "base", "D");
    exponentId  = (*env)->GetFieldID(env, cls, "exponent", "D");

    return JNI_VERSION_1_8;
}

JNIEXPORT jdouble JNICALL Java_StatelessPowerCalculator_calculate
  (JNIEnv *env, jclass clazz, jdouble base, jdouble exponent) {
    return pow(base, exponent);
}

JNIEXPORT jdouble JNICALL Java_StatefulPowerCalculator_calculate
  (JNIEnv *env, jobject thisObj) {
    
    jdouble base = (*env)->GetDoubleField(env, thisObj, baseId);
    jdouble exponent = (*env)->GetDoubleField(env, thisObj, exponentId);

    return pow(base, exponent);
}