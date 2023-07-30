package com.lizza.ThreadStatus;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 LockSupport 加锁, 查看线程状态
 */
public class WaitingTests {

    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            fun();
        }, "t1");

        Thread t2 = new Thread(() -> {
            fun();
        }, "t2");

        t1.start();
        t2.start();
        t2.join();
        t1.join();
    }

    public static void fun() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " obtain lock success!");
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
