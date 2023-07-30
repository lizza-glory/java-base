package com.lizza.CountDownLatch;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 多个任务并行执行, 使用 CountDownLatch 保证每个任务都执行完成后
 * 主线程才能继续进行
 */
public class CountDownLatchTest1 {

    public static void main(String[] args) throws Exception{
        Stopwatch stopwatch = Stopwatch.createStarted();
        CountDownLatch latch = new CountDownLatch(10);
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            new Thread(() -> {
                Stopwatch watch = Stopwatch.createStarted();
                try { Thread.sleep(random.nextInt(1000)); } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName() + " finished task, cost: " + watch.elapsed(TimeUnit.MILLISECONDS));
                latch.countDown();
            }, "thread-" + i).start();
        }
        // 必须调用 await 方法, 等待所有的线程执行完毕
        // 类似: CompletableFuture 的 allOf 方法
        latch.await();
        System.out.println(Thread.currentThread().getName() + " finished, cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
