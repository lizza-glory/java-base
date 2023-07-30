package com.lizza.Thread;

/**
 * 模拟死锁, 使用 jstack 查看死锁信息
 */
public class DeadLock {

    public static void main(String[] args){
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                System.out.println("线程 A 对 a 加了锁");
                try { Thread.sleep(5); } catch (Exception e) {}
                synchronized (b) {
                    System.out.println("线程 A 对 b 加了锁");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("线程 B 对 b 加了锁");
                try { Thread.sleep(5); } catch (Exception e) {}
                synchronized (a) {
                    System.out.println("线程 B 对 a 加了锁");
                }
            }
        }, "B").start();
    }
}
