package com.lizza.Exception;

/**
 * 测试 try-catch-finally 块中的 return 语句执行时机
 */
public class Exception_1 {

    public static void main(String[] args){
        System.out.println(method());
    }

    public static int method() {
        try {
            int i = 1 / 0;
            System.out.println("try 块");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 块");
            return 0;
        }
    }
}
