package com.lizza.ThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-22
 */
public class InheritableThreadLocal_1 extends ThreadLocal {

    public static void main(String[] args){
        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        // 父子线程值传递
        threadLocal.set("lizza");
        new Thread(() -> {
            System.out.println("子线程: " + threadLocal.get());
        }, "name").start();
        System.out.println("父线程: " + threadLocal.get());
    }
}
