package com.lizza.Util;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Semaphore: 信号量
 * 原理
 * 初始化时，需要指定并发度（即 state，可以为负数）
 * 调用 acquire 方法，会将 state 减 1，为 0 时阻塞
 * 调用 release 时，会将 state 加 1
 */
public class SemaphoreTests {

    /**
     * 模拟限流, 每次只能三个通过
     */
    @Test
    public void test1() throws Exception {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i < 8; i++) {
            new Thread(() -> {
                try {
                    // 会占用一个并发度
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " Acquired!");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " Released!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 会释放一个并发度
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
