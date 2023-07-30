package com.lizza.InnerClass;

import org.junit.Test;

/**
 * 内部类
 * 1. 静态内部类
 *      外部类创建内部类实例
 *      外部类调用内部类方法
 *      内部类调用外部类方法
 * 2. 普通内部类
 *      外部类创建内部类实例
 *      外部类调用内部类方法
 *      内部类调用外部类方法
 */
public class InnerClassTest_1 {

    @Test
    public void test1() {
        Test1.Static_Inner inner = new Test1.Static_Inner();
        inner.print2();
    }

    @Test
    public void test2() {
        Test1.Static_Inner inner = new Test1.Static_Inner();
        inner.invokeOuter();
    }

    @Test
    public void test3() {

        Test1.Inner inner = new Test1.Inner();
        inner.invokeOuter();
    }

}

class Test1 {

    static class Static_Inner {

        private void print1() {
            System.out.println("静态内部类 private 方法");
        }

        public void print2() {
            System.out.println("静态内部类 public 方法");
        }

        public void invokeOuter() {
            Test1 outer = new Test1();
            outer.outPrint1();
            outer.outPrint2();
        }

    }

    static class Inner {

        private void print1() {
            System.out.println("静态内部类 private 方法");
        }

        public void print2() {
            System.out.println("静态内部类 public 方法");
        }

        public void invokeOuter() {
            Test1 outer = new Test1();
            outer.outPrint1();
            outer.outPrint2();
        }

    }

    private void outPrint1() {
        System.out.println("外部类 private 方法");
    }

    public void outPrint2() {
        System.out.println("外部类 public 方法");
    }
}