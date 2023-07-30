package com.lizza.ThreadCommunication;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 交替打印 A, B, C 问题
 * 示例:
 * 1. 线程池交替打印数组中对象
 * 2.
 */
public class PrintABC {

    String[] array = new String[]{"A", "B", "C", "D", "E"};
    int current = 0;

    public void print(int index) throws Exception{
        synchronized (this) {
            while (index % array.length != current) {
                this.wait();
            }

            System.out.println(array[current++]);
            current %= array.length;
            this.notifyAll();
        }
    }

    @Test
    public void test1() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            int index = i;
            pool.execute(() -> {
                try {
                    print(index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
