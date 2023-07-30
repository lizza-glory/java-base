package com.lizza.Thread;

import org.junit.Test;

/**
 * 线程中断
 */
public class ThreadInterrupt {

    @Test
    public void test1() throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running!");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }, "thread-1");
        thread.start();
        thread.interrupt();
        System.out.println("main is end");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        thread.interrupt();
        while (Thread.interrupted()) {
            System.out.println(thread.getName() + " is isInterrupted");
        }
        System.out.println("reset");
    }
}
