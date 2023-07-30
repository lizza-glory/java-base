package com.lizza.ThreadStatus;

import java.time.LocalTime;

/**
 * 线程 BLOCKED 状态
 * 1. t1 调用了 sleep 方法, 是 TIMED_WAITING 状态
 * 2. t2 尝试给 obj 加锁, 进入 BLOCKED 状态
 * 3. main 由于 t1, t2 调用 join 方法, 进入 WAITING 状态
 */
public class BlockedTest1 {

    public static void main(String[] args) throws Exception{
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " obtain lock success!");
                while (true) {
                    System.out.println(LocalTime.now());
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " obtain lock success!");
                while (true) {
                    System.out.println(LocalTime.now());
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t2.join();
        t1.join();
    }
}
