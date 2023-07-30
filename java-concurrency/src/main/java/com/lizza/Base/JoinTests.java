package com.lizza.Base;

import org.junit.Test;

/**
 * join方法
 * 当前线程调用其线程A的join方法时, 当前线程会被阻塞,
 * 直到线程A执行完毕(或经过指定时间之后)
 */
public class JoinTests {

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) System.out.println(Thread.currentThread().getName() + " : " + i);
        });
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                thread.start();
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
