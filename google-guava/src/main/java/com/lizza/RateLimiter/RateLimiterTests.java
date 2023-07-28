package com.lizza.RateLimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-25
 */
public class RateLimiterTests {

    public static void main(String[] args){
        RateLimiter limiter = RateLimiter.create(10);
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                limiter.acquire();
                System.out.println(Thread.currentThread().getName() + " is running");
            }, "t-" + i).start();
        }
    }
}
