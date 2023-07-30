package com.lizza.String;

import org.junit.Test;

/**
 * String 字面量
 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.5
 * + 操作符
 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.18.1
 *
 */
public class String_1 {

    @Test
    public void test1() {
        String hello = "Hello", lo = "lo";
        // true
        System.out.println(hello == "Hello");
        // true
        System.out.println(Other.hello == hello);
        // true
        System.out.println(hello == ("Hel"+"lo"));
        // false
        System.out.println(hello == ("Hel"+lo));
        // true
        System.out.println(hello == ("Hel"+lo).intern());
    }
    static class Other {
        static String hello = "Hello";
    }

    @Test
    public void test2() {
        System.out.println("\\u000d");
    }
}
