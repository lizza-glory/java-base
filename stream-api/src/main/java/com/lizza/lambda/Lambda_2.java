package com.lizza.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式语法格式
 *
 */
public class Lambda_2 {

    public static void main(String[] args){
        // 无参无返回值
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
        System.out.println("------------------");

        // 有一个参数, 无返回值
        Consumer<String> con = param -> System.out.println(param);
        con.accept("Hello Lambda!");
        System.out.println("------------------");

        // 有两个以上参数, 有返回值
        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(12, 3));
        System.out.println("------------------");

    }
}
