package com.lizza.Exception;

/**
 * 验证 jit 编译, 异常栈丢失
 * 1. 如果循环中打印异常栈, 间隔时间较短, 则异常栈的打印顺序会发生变化
 */
public class JitException {

    public static void main(String[] args) {
        for (int i = 0; i < 5200; i++) {
            fun(args);
        }
    }

    static void fun(String[] args) {
        try {
            System.out.println(args[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}