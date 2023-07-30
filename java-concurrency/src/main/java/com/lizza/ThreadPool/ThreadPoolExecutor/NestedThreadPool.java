package com.lizza.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @Desc: 嵌套线程池
 * @author: lizza.liu
 * @date: 2022-03-08
 */
public class NestedThreadPool {

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
                        return new Thread(r, "outer-thread");
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
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": task is finished, id: " + finalI);
                    ThreadPoolExecutor innerPool = new ThreadPoolExecutor(
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
                                    return new Thread(r, "inner-thread");
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
                    for (int j = 0; j < 10; j++) {
                        int finalJ = j;
                        innerPool.execute(() -> {
                            System.out.println(Thread.currentThread().getName() + ": task is finished, id: " + finalJ);
                            try { Thread.sleep(1000); } catch (Exception e) {}
                        });
                    }
                    innerPool.shutdown();
                }
            });
        }
        executor.shutdown();
    }
}
