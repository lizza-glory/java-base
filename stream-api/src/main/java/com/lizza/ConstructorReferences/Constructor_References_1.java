package com.lizza.ConstructorReferences;

import java.util.function.Supplier;

/**
 * 构造器引用
 */
public class Constructor_References_1 {

    public static void main(String[] args){
        Supplier supplier = String::new;
        supplier.get();
    }
}
