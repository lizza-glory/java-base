package com.lizza.ParallelCompute;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-13
 */
public class Compute_1 extends AbstractComputer {

    @Override
    String compute() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Future<String> futureA = COMPUTER_EXECUTOR_SERVICE.submit(() -> {
            try {
                int time = 200 + new Random().nextInt(300);
                Thread.sleep(time);
                System.out.println("\tCompute_1 futureA cost: " + time);
            } catch (InterruptedException e) {
                System.out.println("Compute_1 futureA error, cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
                e.printStackTrace();
            }
            return null;
        });
        Future<String> futureB = COMPUTER_EXECUTOR_SERVICE.submit(() -> {
            try {
                int time = 50 + new Random().nextInt(100);
                Thread.sleep(time);
                System.out.println("\tCompute_1 futureB cost: " + time);
            } catch (InterruptedException e) {
                System.out.println("\tCompute_1 futureB error, cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
                e.printStackTrace();
            }
            return null;
        });
        try {
            futureA.get(300, TimeUnit.MILLISECONDS);
            futureB.get(300, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("\tCompute_1 error, cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            e.printStackTrace();
        } finally {
            System.out.println("Compute_1 cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        return null;
    }

    @Override
    String name() {
        return "Compute_1";
    }
}
