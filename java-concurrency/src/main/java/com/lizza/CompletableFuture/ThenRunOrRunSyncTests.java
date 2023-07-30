package com.lizza.CompletableFuture;

import com.lizza.Util.Logger;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thenRun 和 thenRunSync
 * 1. 都可以在前一个 CompletableFuture 执行完成后, 继续执行后续的 CompletableFuture
 * 2. thenRun 使用的是前一个 CompletableFuture 的线程池
 * 3. thenRunAsync 如果传递了线程池, 则使用传递的, 否则使用 ForkJoinPool.commonPool
 */
public class ThenRunOrRunSyncTests {

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    @Test
    public void test1() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Logger.info("future1 执行");
            return "future1 执行";
        }, executor);
        // 在 future1 执行完成之后, 执行 future2
        CompletableFuture<Void> future2 = future1.thenRun(() -> {
            Logger.info("future2 执行");
        });
        // future2 执行完成后, 执行 future3
        CompletableFuture<Void> future3 = future2.thenRunAsync(() -> {
            Logger.info("future3 执行");
        });
        // future3 执行完成后, 执行 future4
        CompletableFuture<Void> future4 = future3.thenRunAsync(() -> {
            Logger.info("future4 执行");
        }, executor);
        future4.join();
    }
}
