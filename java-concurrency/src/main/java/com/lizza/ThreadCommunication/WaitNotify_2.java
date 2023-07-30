package com.lizza.ThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目: 4个线程，交替打印A、B、C，循环10次; 使用等待通知机制实现
 *
 * 思路: 使用Lock + await/signal + Condition + 状态量实现
 */
public class WaitNotify_2 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private String flag = "A";

    private void printA() {
        lock.lock();
        try {
            while (flag != "A") condition.await();
            System.out.println(Thread.currentThread().getName() + ": A");
            this.flag = "B";
            condition.signalAll();
        } catch (Exception e) {} finally { lock.unlock(); }

    }

    private void printB() {
        lock.lock();
        try {
            while (flag != "B") condition.await();
            System.out.println(Thread.currentThread().getName() + ": B");
            this.flag = "C";
            condition.signalAll();
        } catch (Exception e) {} finally { lock.unlock(); }

    }

    private void printC() {
        lock.lock();
        try {
            while (flag != "C") condition.await();
            System.out.println(Thread.currentThread().getName() + ": C");
            this.flag = "A";
            condition.signalAll();
        } catch (Exception e) {} finally { lock.unlock(); }

    }

    public static void main(String[] args){
        WaitNotify_2 object = new WaitNotify_2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) object.printA();
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) object.printB();
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) object.printC();
        }, "t3").start();
    }

}
