package com.lizza.Atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 实现原子自增 计数器
 */
public class AtomicIntegerTest {

    @Test
    public void test1() {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println(count.getAndIncrement());
        System.out.println(count.get());
    }
}
