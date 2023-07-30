package com.lizza.Exercise.exercise_03;

/**
 * 题目: 4个线程, 操作一个初始值为0的数据, 一个线程每次对数据加1,
 * 另一个线程每次对该数据减1, 实现交替, 操作5次, lock实现
 * 虚假唤醒: 多线程通信时，不能使用if进行判断，因为这样可能会造成虚假唤醒；要使用while进行判断
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
        new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.increase();
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.decrease();
        }, "D").start();
    }
}
