package com.lizza.FunctionalInterface;

import java.util.function.Consumer;

/**
 * 自定义函数式接口测试
 */
public class Func_1 {

    public static void main(String[] args){
        FuncInterface_1 func_1 = object -> object.hashCode();
        System.out.println(func_1.method("Func_1"));
        Consumer<String> con = System.out::println;
        System.out.println();
    }
}
