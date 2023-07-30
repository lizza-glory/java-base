package com.lizza.Util;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁
 *
 */
public class CountDownLatchTests {

    @Test
    public void test1() throws Exception {
        CountDownLatch counter = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 业务处理
                // do somethings
                counter.countDown();
            }, String.valueOf(i)).start();
        }
        counter.await();
    }
}
