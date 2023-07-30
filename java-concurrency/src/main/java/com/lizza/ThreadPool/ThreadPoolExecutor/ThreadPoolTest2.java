package com.lizza.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 看看提交的任务, 线程池是如何执行的
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(
                64, 512, 60, TimeUnit.SECONDS,
                new SynchronousQueue(), r -> {
                    Thread thread = new Thread(r);
                    thread.setName("custom-pool-1");
                    return thread;
                }, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            int num = i;
            Integer result = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " execute.");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return num;
            }).get();
        }
    }
}
