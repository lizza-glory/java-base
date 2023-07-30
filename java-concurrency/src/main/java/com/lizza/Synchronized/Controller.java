package com.lizza.Synchronized;

public class Controller {

    private final Object object = new Object();

    public void func1() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + ": func1 do something start...");
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": func1 do something finished...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void func2() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + ": func2 do something start...");
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + ": func2 do something finished...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
