package com.lizza.CompletableFuture;

import com.lizza.Util.Logger;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenAcceptTests {

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    @Test
    public void test1() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Logger.info("future1 执行");
            return "future1 执行";
        }, executor);
        // 在 future1 执行完成之后, 执行 future2, 并且可以接收处理 future1 的处理结果
        CompletableFuture<Void> future2 = future1.thenAccept(param -> {
            Logger.info("param: {}", param);
            Logger.info("future2 执行");
        });
        future2.join();
        // 如果没有传线程池, 则使用 ForkJoinPool.commonPool
        CompletableFuture<Void> future3 = future1.thenAcceptAsync(param -> {
            Logger.info("param: {}", param);
            Logger.info("future3 执行");
        });
        future3.join();
        // 传递了线程池, 使用传入的线程池
        CompletableFuture<Void> future4 = future1.thenAcceptAsync(param -> {
            Logger.info("param: {}", param);
            Logger.info("future4 执行");
        }, executor);
        future4.join();
    }
}
