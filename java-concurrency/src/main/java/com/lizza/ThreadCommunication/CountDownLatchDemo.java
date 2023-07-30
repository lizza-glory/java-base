package com.lizza.ThreadCommunication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class CountDownLatchDemo {

    private Integer count = 10;
    private Lock lock = new ReentrantLock();

    private void sale() {
        lock.lock();
        try {
            System.out.println("The remaining " + count-- + " things");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 25; i++) {
            new Thread(() -> {
                latch.countDown();
                demo.sale();
            }, "T" + i).start();
        }
        latch.await();
        System.out.println("The count is " + demo.count);
    }
}
