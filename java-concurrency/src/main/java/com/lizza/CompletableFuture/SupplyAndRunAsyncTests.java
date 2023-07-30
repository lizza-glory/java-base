package com.lizza.CompletableFuture;

import com.google.common.collect.Lists;
import com.lizza.Util.Logger;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * runAsync 和 supplyAsync
 */
public class SupplyAndRunAsyncTests {

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * 1. 测试 supplyAsync 和 runSync
     * 2. 测试如果没有传入自定义的线程池, 则使用 ForkJoinPool
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "hello supplyAsync";
        }, executor);
        Logger.info(future1.get());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            Logger.info("hello runAsync");
        }, executor);
        Void result = future2.get();
        Logger.info("result: {}", result);
        // 如果没有指定线程池, 使用的是 ForkJoinPool.commonPool
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            Logger.info("hello runAsync, no custom thread pool");
        });
        Logger.info("result: {}", future3.get());
    }

    @Test
    public void test2() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "hello supplyAsync";
        }, executor);
        System.out.println(future1.get());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("hello runAsync");
        }, executor);
        Void result = future2.get();
        System.out.println(result);
    }
    
    @Test
    public void test10() {
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            int result = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                if (result % 2 != 0) {
                    try {
                        Thread.sleep(550);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return result;
            });
            future.obtrudeValue(-1);
            futureList.add(future);
        }
        for (CompletableFuture<Integer> future : futureList) {
            try {
                System.out.println(future.get(200, TimeUnit.MILLISECONDS));
                future.whenComplete((integer, throwable) -> System.out.println("\t123" + integer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test20() throws Exception {
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 15; i++) {
            int num = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                if (num == 7) {
                    throw new RuntimeException("7 is error");
                }
                if (num == 13) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return num;
            }));
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        for (CompletableFuture<Integer> future : futureList) {
            System.out.println(future.get(500, TimeUnit.MILLISECONDS));
        }
        System.out.println();
    }
}
