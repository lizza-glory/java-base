package com.lizza.Final;

/**
 * 被final修饰的类不可以被继承
 * 被final修饰的方法不可以被重写
 * 被final修饰的变量不可以被改变，被final修饰不可变的是变量的引用，而不是引用指向的内容，引用指向的内容是可以改变的
 */
public final class Final {

    final Integer number = 1;

    final Integer getNumber() {
        return number;
    }
}
