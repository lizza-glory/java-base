package com.lizza.Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * compareAndSwapInt(Object var1, long var2, int var3, int var4)
 * var1: 内存中的一个对象, 即共享变量
 * var2: 该对象在内存中的内存地址
 * var3: 原来的值
 * var4: 改变后的值
 */
public class CASInt_1 {

    public static void main(String[] args) throws Exception {
        CASInt_1 cas = new CASInt_1();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        int value = 10;
        long offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        boolean flag = unsafe.compareAndSwapInt(cas, offset, 10, 20);
        System.out.println("flag: " + flag + ", value: " + value);
    }
}
