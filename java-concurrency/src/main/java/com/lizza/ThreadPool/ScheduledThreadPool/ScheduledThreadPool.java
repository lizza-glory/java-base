package com.lizza.ThreadPool.ScheduledThreadPool;

import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时/延迟调度线程池
 */
public class ScheduledThreadPool {

    // 立即执行任务
    @Test
    public void test1() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " task running...");
        });
    }

    // 程序启动后, 延迟 3 秒后开始执行, 一秒执行一次
    @Test
    public void test2() throws Exception {
        System.out.println(LocalTime.now());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(() -> {
            System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " task running...");
        }, 3, 1, TimeUnit.SECONDS);
        System.in.read();
    }

    // 延迟执行任务, 并返回结果
    @Test
    public void test3() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        ScheduledFuture<LocalTime> scheduledFuture = executor.schedule(() -> {
            LocalTime time = LocalTime.now();
            System.out.println(time + " - " + Thread.currentThread().getName() + " task running...");
            return time;
        }, 1, TimeUnit.SECONDS);
        System.out.println("result: " + scheduledFuture.get());
    }

    // 模拟任意一次任务异常, 如果没有捕获, 那么其他任务不会继续执行
    @Test
    public void test4() throws Exception {
        AtomicInteger count = new AtomicInteger();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(() -> {
            if (count.getAndIncrement() == 2) {
                try {
                    throw new RuntimeException("task execute exception...");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException("task execute exception...");
                }
            }
            System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " task running, count: " + count.get());
        }, 0, 1, TimeUnit.SECONDS);
        System.in.read();
    }
}
