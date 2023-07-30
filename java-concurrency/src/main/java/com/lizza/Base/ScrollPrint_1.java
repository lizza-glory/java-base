package com.lizza.Base;

import org.junit.Test;

/**
 * 线程 1 打印 A, B, C; 线程 2 打印 1, 2, 3
 * 交替打印: A, 1, B, 2, C, 3, A, 1, B, 2...
 *
 * 使用 wait/notify 实现
 */
public class ScrollPrint_1 {

    boolean flag = false;

    int i = 0, j = 0;

    int[] nums = new int[]{1, 2, 3};

    String[] strings = new String[]{"a", "b", "c"};

    void printNums() throws Exception {
        synchronized (this) {
            while (flag) {
                this.wait();
            }
            i = i == nums.length ? 0 : i;
            System.out.println(nums[i++]);
            flag = true;
            this.notify();
        }
    }

    void printStrings() throws Exception {
        synchronized (this) {
            while (!flag) {
                this.wait();
            }
            j = j == strings.length ? 0 : j;
            System.out.println(strings[j++]);
            flag = false;
            this.notify();
        }
    }

    @Test
    public void test1() throws Exception {
        ScrollPrint_1 print = new ScrollPrint_1();
        new Thread(() -> {
            try {
                for (int k = 0; k < 4; k++) {
                    print.printNums();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "thread-a").start();
        new Thread(() -> {
            try {
                for (int k = 0; k < 4; k++) {
                    print.printStrings();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "thread-b").start();
        Thread.currentThread().join();
    }
}
