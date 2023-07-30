package com.lizza.Volatile;

/**
 * 1000 个线程对一个变量 ++ 操作
 */
public class IncrTests {

    private static volatile int count = 0;

    public static void incr() {
        try { Thread.sleep(1); } catch (Exception e) {}
        count++;
    }

    public static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                incr();
            }).start();
        }
        try { Thread.sleep(3000); } catch (Exception e) {}
        System.out.println(count);
    }
}
