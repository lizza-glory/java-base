package com.lizza.Sync;

/**
 * 题目: 线程8锁
 * 1. 2个普通同步方法方法m1, m2; 线程A, B分别去调用m1, m2, 问执行顺序
 * 2. 在1的基础上, m1执行时暂停3s, 问执行顺序
 * 3. 在2的基础上, 新增普通方法m, 线程A, B, C分别依次调用m1, m2, m问执行顺序
 * 4. 2个普通同步方法m1, m2; m1执行时暂停3s; 两个对象f1, f2, 线程A调用f1的m1, B调用f2的m2, 问执行顺序
 * 5. 2个静态同步方法方法m1, m2; 1执行时暂停3s, 线程A, B分别去调用m1, m2, 问执行顺序
 * 6. 2个静态同步方法方法m1, m2, 1执行时暂停3s; 两个对象f1, f2, 线程A, B分别去调用f1的m1, f2的m2, 问执行顺序
 * 7. 一个普通同步方法m1, 执行时暂停3s; 一个静态同步方法, 一个对象, 线程A, B分别去调用m1, m2, 问执行顺序
 * 8. 一个普通同步方法m1, 执行时暂停3s; 一个静态同步方法; 两个对象f1, f2, 线程A, B分别去调用f1的m1, f2的m2, 问执行顺序
 * 9. 一个静态同步方法m1，执行时暂停3s；一个普通方法；两个对象f1，f2，线程A，B分别去调用f1的m1，f2的m2，问执行顺序
 *
 * 笔记
 * 1. 一个对象里面如果有多个synchronized方法, 在某一时刻, 只要一个线程去调用其中一个synchronized方法
 * 其它的线程都只能等待; 换句话说, 在某一时刻, 只能有唯一一个线程去访问这些synchronized方法, 锁的是当前
 * 对象this, 被锁定后, 其它的线程都不能进入到当前对象的其它的synchronized方法
 * 2. 加个普通方法后发现和同步锁无关
 * 3. 换成两个对象后, 不是同一把锁了, 情况立刻变化。
 * 4. 都换成静态同步方法后, 情况又变化
 * 5. 所有的非静态问同步方法用的都是同一把锁: 即实例对象本身
 * 6. synchronized实现同步的基础: Java中的每一个象都可以作为锁; 具体表现为以下3种形式:
 *      6.1 对于普通同步方法, 锁是当前实例衬象
 *      6.2 对于静态同步方法, 锁是当前类Class对象
 */
public class Thread_13 {

    public static void main(String[] args) throws Exception{
        test10();
    }

    public static void test1() throws Exception {
        Function1 function = new Function1();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m2();
        }, "B").start();
    }

    public static void test2() throws Exception {
        Function2 function = new Function2();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m2();
        }, "B").start();
    }

    public static void test3() throws Exception {
        Function3 function = new Function3();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m2();
        }, "B").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m();
        }, "C").start();
    }

    public static void test4() throws Exception {
        Function4 f1 = new Function4();
        Function4 f2 = new Function4();
        new Thread(() -> {
            f1.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            f2.m2();
        }, "B").start();
    }

    public static void test5() throws Exception {
        Function5 function = new Function5();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m2();
        }, "B").start();
    }

    public static void test6() throws Exception {
        Function6 f1 = new Function6();
        Function6 f2 = new Function6();
        new Thread(() -> {
            f1.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            f2.m2();
        }, "B").start();
    }

    public static void test7() throws Exception {
        Function7 function = new Function7();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            function.m2();
        }, "B").start();
    }

    public static void test8() throws Exception {
        Function8 f1 = new Function8();
        Function8 f2 = new Function8();
        new Thread(() -> {
            f1.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            f2.m2();
        }, "B").start();
    }

    public static void test9() throws Exception {
        Function9 f1 = new Function9();
        Function9 f2 = new Function9();
        new Thread(() -> {
            f1.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            f2.m2();
        }, "B").start();
    }

    public static void test10() throws Exception {
        Function10 function = new Function10();
        new Thread(() -> {
            function.m1();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            Function10.m2();
        }, "B").start();
    }
}

class Function1 {

    public synchronized void m1() {
        System.out.println("Invoke Method1");
    }

    public synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function2 {

    public synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function3 {

    public synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public synchronized void m2() {
        System.out.println("Invoke Method2");
    }

    public void m() {
        System.out.println("Invoke Method");
    }
}

class Function4 {

    public synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function5 {

    public static synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public static synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function6 {

    public static synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public static synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function7 {

    public synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public static synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function8 {

    public synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public static synchronized void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function9 {

    public static synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public void m2() {
        System.out.println("Invoke Method2");
    }
}

class Function10 {

    public static synchronized void m1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Invoke Method1");
    }

    public static void m2() {
        System.out.println("Invoke Method2");
    }
}
