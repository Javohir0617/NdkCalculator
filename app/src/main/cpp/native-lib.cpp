#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkcalculator_MainActivity_plusNumbrs(
        JNIEnv *env,
        jobject,
        jint a, jint b) {
    return a + b;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkcalculator_MainActivity_minusNumbrs(
        JNIEnv *env,
        jobject,
        jint a, jint b) {
    return a - b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_ndkcalculator_SecondActivity_plusNumbrs(
        JNIEnv *env,
        jobject,
        jdouble a, jdouble b) {
    return a + b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_ndkcalculator_SecondActivity_minusNumbrs(
        JNIEnv *env,
        jobject,
        jdouble a, jdouble b) {
    return a - b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_ndkcalculator_SecondActivity_divadeNumbrs(
        JNIEnv *env,
        jobject,
        jdouble a, jdouble b) {
    return a / b;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_ndkcalculator_SecondActivity_multipNumbrs(
        JNIEnv *env,
        jobject,
        jdouble a, jdouble b) {
    return a * b;
}