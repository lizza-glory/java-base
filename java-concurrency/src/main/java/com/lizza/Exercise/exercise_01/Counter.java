package com.lizza.Exercise.exercise_01;

public class Counter {

    private int count;

    public synchronized void increase() {
        // 判断: 若count不为0, 说明执行increase()方法的线程应该阻塞, 让执行decrease()方法的线程执行
        if (count != 0) try { this.wait(); } catch (Exception e) {}
        // 干活: 执行实际的操作
        count++;
        // 通知: 操作完成后通知其他线程继续
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }

    public synchronized void decrease() {
        // 判断: 若count为0, 说明执行decrease()方法的线程应该阻塞, 让执行increase()方法的线程执行
        if (count == 0) try { this.wait(); } catch (Exception e) {}
        // 干活: 执行实际的操作
        count--;
        // 通知: 操作完成后通知其他线程继续
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
}
