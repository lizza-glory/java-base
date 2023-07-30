package com.lizza.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * 线程池
 * 1. 核心参数
 * 2. 核心类, 方法
 */
public class ThreadPoolTests {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                // 核心线程数
                Runtime.getRuntime().availableProcessors(),
                // 最大线程数
                Runtime.getRuntime().availableProcessors(),
                // 非核心线程数的存活时间
                10L,
                // 时间单位
                TimeUnit.SECONDS,
                // 任务队列
                new ArrayBlockingQueue<>(16),
                // 线程工厂
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "test-thread-pool");
                    }
                },
                // 拒绝策略
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(">>> Thread Reject, TaskCount: " + executor.getTaskCount()
                                + ", CompletedTaskCount: " + executor.getCompletedTaskCount()
                                + ", ActiveCount: " + executor.getActiveCount());
                    }
                }
        );
        for (int i = 0; i < 32; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": task is finished, id: " + finalI);
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            });
        }
        executor.shutdown();
    }
}
