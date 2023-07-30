package com.lizza.ForkJoin;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;

/**
 * @Desc: ForkJoinPool
 * @author: lizza.liu
 * @date: 2021-08-03
 */
public class ForkJoinPool_1 {

    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool(17);
        pool.submit(() -> {
            while (true) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        while (true){}
    }
}
