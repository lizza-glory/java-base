package com.lizza.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 多个任务并行执行, 使用 CountDownLatch 保证每个任务都执行完成后
 * 主线程才能继续进行
 */
public class CountDownLatchTest2 {

    static int count = 0;

    static void incr() {
        try { Thread.sleep(1); } catch (Exception e) {}
        count++;
    }

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                incr();
                System.out.println(Thread.currentThread().getName() + " finished task, count: " + count);
                latch.countDown();
            }, "thread-" + i).start();
        }
        // 必须调用 await 方法, 等待所有的线程执行完毕
        // 类似: CompletableFuture 的 allOf 方法
        latch.await();
        System.out.println(Thread.currentThread().getName() + " finished, count: " + count);
    }
}
