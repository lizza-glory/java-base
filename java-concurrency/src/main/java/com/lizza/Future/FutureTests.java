package com.lizza.Future;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTests {

    private static ExecutorService executorService1 = new ThreadPoolExecutor(
            64, 512, 60, TimeUnit.SECONDS,
            new SynchronousQueue(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("custom-pool-1");
            return thread;
        }
    }, new ThreadPoolExecutor.AbortPolicy());
    private static ExecutorService executorService2 = Executors.newFixedThreadPool(10);

    public static int fun1() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static int fun2() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2;
    }

    public static int fun3() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 3;
    }

    public static int fun4() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 4;
    }

    public static int fun5() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 5;
    }

    public static int slow() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 7;
    }

    /**
     * 模拟慢的任务
     */
    public static void task1() throws Exception {
        List<Future<Integer>> list = new ArrayList<>();
        // 模拟一下占用 10 个线程
        for (int i = 0; i < 10; i++) {
            list.add(executorService2.submit(FutureTests::slow));
        }
        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }

    public static void task2() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Future<Integer>> list = new ArrayList<>();
        list.add(executorService1.submit(FutureTests::fun1));
        list.add(executorService1.submit(FutureTests::fun2));
        list.add(executorService1.submit(FutureTests::fun3));
        list.add(executorService1.submit(FutureTests::fun4));
        list.add(executorService1.submit(FutureTests::fun5));
        for (Future<Integer> future : list) {
            future.get();
        }
        System.out.println("cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            new Thread(() -> {
                try {
                    task1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "thread-1").start();
            new Thread(() -> {
                try {
                    task2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "thread-2").start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
