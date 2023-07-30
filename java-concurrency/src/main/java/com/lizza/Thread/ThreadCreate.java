package com.lizza.Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程创建的四种方式
 * 1. 继承 Thread 类重写run方法
 * 2. 实现 Runnable 接口, 重写run方法
 * 3. 利用 FutureTask 创建可以返回结果的线程
 * 4. 线程池创建线程
 */
public class ThreadCreate {

    /**
     * 继承Thread类重写run方法
     * 如果 run 方法内部有异常, 不会中断主线程
     */
    @Test
    public void test1() {
        class CustomThread extends Thread {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Is Running!");
                int i = 1/0;
            }
        }
        new CustomThread().start();
        System.out.println(Thread.currentThread().getName() + " Is Running!");
    }

    @Test
    // 实现Runnable接口, 重写run方法
    public void test2() throws Exception {

        class Worker implements Runnable {

            Thread thread;

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Is Running!");
            }
        }

        Worker worker = new Worker();
        Thread thread = new Thread(worker, "worker-thread");

        worker.thread = thread;
        thread.start();
        thread.join();

        System.out.println(Thread.currentThread().getName() + " Is Running!");
    }

    /**
     * 利用 FutureTask 创建可以返回结果的线程
     * 如果线程中抛出异常, 只要不调用 get 方法, 不会中断主线程
     */
    @Test
    public void test3() throws Exception{
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = Thread.currentThread().getName() + " Is Running!";
                int i = 1/0;
                return result;
            }
        });
        new Thread(task).start();
        System.out.println("get result before");
        System.out.println(Thread.currentThread().getName() + " Is Running! "
            + "Task Result: " + task.get());
        System.out.println("get result after");
    }

    @Test
    // 利用线程池获取线程
    public void test5() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                // 核心线程数
                Runtime.getRuntime().availableProcessors(),
                // 最大线程数
                Runtime.getRuntime().availableProcessors(),
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(16),
                // 线程池工厂, 可以自定义名称
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "test-thread");
                    }
                },
                // 拒绝策略
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        // 打日志, 做监控
                        System.out.println("Thread rejected, " +
                                "ActiveCount: " + executor.getActiveCount() + ", " +
                                "TaskCount: " + executor.getTaskCount() + ", " +
                                "CompletedTaskCount: " + executor.getCompletedTaskCount());
                    }
                }
        );
        for (int i = 0; i < 50; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " Is Running!");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}