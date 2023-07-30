package com.lizza.Sync;

import org.junit.Test;

/**
 *
 */
public class SynchronizedTests {

    @Test
    public void test1() {
        Fun1 fun = new Fun1();
        new Thread(() -> {
            fun.m1();
        }, "a").start();
        new Thread(() -> {
            fun.m2();
        }, "b").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @Test
    public void test2() {
        Fun2 fun = new Fun2();
        new Thread(() -> {
            fun.m1();
        }, "a").start();
        new Thread(() -> {
            fun.m2();
        }, "b").start();
        new Thread(() -> {
            fun.m3();
        }, "c").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @Test
    public void test3() {
        Fun3 fun1 = new Fun3();
        Fun3 fun2 = new Fun3();
        new Thread(() -> {
            fun1.m1();
        }, "a").start();
        new Thread(() -> {
            fun2.m2();
        }, "b").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @Test
    public void test4() {
        new Thread(() -> {
            Fun4.m1();
        }, "a").start();
        new Thread(() -> {
            Fun4.m2();
        }, "b").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @Test
    public void test5() {
        Fun5 fun = new Fun5();
        new Thread(() -> {
            Fun5.m1();
        }, "a").start();
        new Thread(() -> {
            fun.m2();
        }, "b").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @Test
    public void test6() {
        Fun6 fun1 = new Fun6();
        Fun6 fun2 = new Fun6();
        new Thread(() -> {
            fun1.m1();
        }, "a").start();
        new Thread(() -> {
            fun2.m2();
        }, "b").start();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }
}

class Fun1 {
    synchronized void m1() {
        try { Thread.sleep(300); } catch (Exception e) {}
        System.out.println("invoke m1");
    }

    synchronized void m2() {
        System.out.println("invoke m2");
    }
}

class Fun2 {
    synchronized void m1() {
        try { Thread.sleep(300); } catch (Exception e) {}
        System.out.println("invoke m1");
    }

    synchronized void m2() {
        System.out.println("invoke m2");
    }

    void m3() {
        System.out.println("invoke m3");
    }
}

class Fun3 {
    synchronized void m1() {
        try { Thread.sleep(300); } catch (Exception e) {}
        System.out.println("invoke m1");
    }

    synchronized void m2() {
        System.out.println("invoke m2");
    }
}

class Fun4 {
    static synchronized void m1() {
        try { Thread.sleep(300); } catch (Exception e) {}
        System.out.println("invoke m1");
    }

    static synchronized void m2() {
        System.out.println("invoke m2");
    }
}

class Fun5 {
    static synchronized void m1() {
        try { Thread.sleep(300); } catch (Exception e) {}
        System.out.println("invoke m1");
    }

    synchronized void m2() {
        System.out.println("invoke m2");
    }
}

class Fun6 {
    void m1() {
        synchronized (Fun6.class) {
            try { Thread.sleep(300); } catch (Exception e) {}
            System.out.println("invoke m1");
        }
    }

    static synchronized void m2() {
        System.out.println("invoke m2");
    }
}
