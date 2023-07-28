package com.lizza.MethodReferences;

import com.lizza.FunctionalInterface.FuncInterface_1;

import java.util.function.Consumer;

/**
 * 方法引用 1
 */
public class Method_References_1 {
    public static void main(String[] args){
        Consumer<String> con = System.out::println;
        con.accept("方法引用");
    }
}
