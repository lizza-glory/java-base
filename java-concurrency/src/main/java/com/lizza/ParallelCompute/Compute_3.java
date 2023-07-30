package com.lizza.ParallelCompute;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-13
 */
public class Compute_3 extends AbstractComputer {

    @Override
    String compute() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            int time = 80 + new Random().nextInt(100);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("\tCompute_3 futureC error, cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            e.printStackTrace();
        } finally {
            System.out.println("Compute_3 cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        return null;
    }

    @Override
    String name() {
        return "Compute_3";
    }
}
