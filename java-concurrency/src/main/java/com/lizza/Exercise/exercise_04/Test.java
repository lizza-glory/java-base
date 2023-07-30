package com.lizza.Exercise.exercise_04;

/**
 * 题目: 三个线程依次调用, 顺序打印A, B, C
 */
public class Test {

    public static void main(String[] args){
        Printer printer = new Printer();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printC();
            }
        }, "C").start();
    }
}
