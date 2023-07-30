package com.lizza.Exercise.exercise_01;

/**
 * 题目: 两个线程, 操作一个初始值为0的数据, 一个线程每次对数据加1,
 * 另一个线程每次对该数据减1, 实现交替, 操作5次
 */
public class Test {

    public static void main(String[] args){
        Counter counter = new Counter();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.increase();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.decrease();
        }, "B").start();
    }
}
