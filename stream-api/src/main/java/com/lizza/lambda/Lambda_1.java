package com.lizza.lambda;

/**
 * 从匿名内部类到 Lambda 的转换
 */
public class Lambda_1 {

    public static void main(String[] args){
        // 匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r1.run();
        System.out.println("------------------");
        // lambda 表达式
        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }
}
