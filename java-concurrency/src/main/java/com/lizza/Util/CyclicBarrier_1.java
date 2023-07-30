package com.lizza.Util;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier: 循环的栅栏
 */
public class CyclicBarrier_1 {

    /**
     * 循环栅栏, 可以多次利用
     * 假设有个业务场景, 完成它总共需要 3 个环节, 每个环节有 4 个资源需要并发获取, 4 个资源的耗时不一致
     * 每个环节开始执行都依赖于前一个环节所有资源都获取到
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                try {
                    // 环节 1
                    Logger.info("Step 1 start >>>");
                    int cost = new Random().nextInt(3000);
                    Thread.sleep(cost);
                    Logger.info("Step 1 finished, cost: {}", cost);
                    barrier.await();

                    // 环节 2
                    Logger.info("Step 2 start >>>");
                    int cost2 = new Random().nextInt(3000);
                    Thread.sleep(cost2);
                    Logger.info("Step 2 finished, cost: {}", cost2);
                    barrier.await();

                    // 环节 3
                    Logger.info("Step 3 start >>>");
                    int cost3 = new Random().nextInt(3000);
                    Thread.sleep(cost3);
                    Logger.info("Step 3 finished, cost: {}", cost3);
                    barrier.await();
                } catch (Exception e) {
                    Logger.info("exception", e);
                }
            });
        }
        Thread.currentThread().join();
        executor.shutdown();
    }

    @Test
    public void test2() throws Exception {
        System.out.println(new Random().nextInt(3000));
        System.out.println(new Random().nextInt(3000));
        System.out.println(new Random().nextInt(3000));
    }
}
