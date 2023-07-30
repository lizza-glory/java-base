package com.lizza.String.intern;

import org.junit.Test;

/**
 * 链接：https://juejin.cn/post/6882889197997260813
 */
public class StringInternTests {

    @Test
    public void test1() {
        String s1 = new String("a");
        String s2 = new String("a");
        // false, 两个 String 对象的引用必不相等
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        String s1 = "a";
        String s2 = "a";
        // true ?
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String s1 = new String("1");
        String s2 = "1";
        // false s1 指向堆中的对象, s2 指向堆中常量池的常量
        System.out.println(s1 == s2);
    }

    @Test
    public void test4() {
        String s1 = new String("1");
        String s2 = "1";
        s1 = s1.intern();
        // true ?
        System.out.println(s1 == s2);
    }

    @Test
    public void test5() {
        String s1 = "a" + "b";
        String s2 = "ab";
        // true ?
        System.out.println(s1 == s2);
    }

    @Test
    public void test6() {
        String s1 = new String("a") + new String("b");
        s1.intern();
        String s2 = "ab";
        // true ? s1.intern() 会去常量池检查, 如果没有 ab, 就把 ab 放到常量池
        // 并将 s1 指向常量池中常量
        // s2 = "ab" 会去常量池看, 如果有, 就直接指向常量池中常量
        System.out.println(s1 == s2);
    }

    @Test
    public void test7() {
        String s1 = new String("a") + new String("b");
        String s2 = "ab";
        s1.intern();
        // false ?
        System.out.println(s1 == s2);
    }

    @Test
    public void test8() {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        // false s1.intern() 会将 1 加入到常量池, 但 s1 仍然指向堆中对象
        // 对象指向常量池中 1
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        // false 同上
        System.out.println(s3 == s4);
    }

    @Test
    public void test9() {
        String s1 = new String("1");
        String s2 = "1";
        s1.intern();
        // false 同上
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        // false 同上
        System.out.println(s3 == s4);
    }

    @Test
    public void test10() {
        String s1 = new String("1") + new String("1");
        String s2 = "11";
        String s3 = s1.intern();
        // false
        System.out.println(s1 == s2);
        // true
        System.out.println(s3 == s2);
    }

}
