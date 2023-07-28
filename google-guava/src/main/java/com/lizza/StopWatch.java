package com.lizza;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-21
 */
public class StopWatch {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Stopwatch innerStopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println(innerStopwatch.elapsed(TimeUnit.MILLISECONDS));
            innerStopwatch.reset();
            innerStopwatch.start();
        }
        System.out.println("final: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }
}
