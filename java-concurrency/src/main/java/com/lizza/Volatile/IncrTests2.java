package com.lizza.Volatile;

/**
 * 1000 个线程对一个变量 ++ 操作
 */
public class IncrTests2 {

    private static int count = 0;

    public synchronized static void incr() {
        try { Thread.sleep(2); } catch (Exception e) {}
        count++;
    }

    public static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            new Thread(IncrTests2::incr).start();
        }
        try { Thread.sleep(3000); } catch (Exception e) {}
        System.out.println(count);
    }
}
