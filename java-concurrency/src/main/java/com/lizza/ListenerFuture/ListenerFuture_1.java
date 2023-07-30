package com.lizza.ListenerFuture;

import com.google.common.util.concurrent.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class ListenerFuture_1 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

        ListenableFuture<String> listenableFuture = pool.submit(() -> {
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
            return "Guava Listening future result";
        });


        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            public void onSuccess(String s) {
                latch.countDown();
                System.out.println(s);
            }

            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        }, pool);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
