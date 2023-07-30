package com.lizza.Final;

import org.junit.Test;

/**
 * final 修饰局部变量
 */
public class FinalField {

    int a = 1;
    String s = "hello";
    User user = new User(1, "jack");

    @Test
    public void test1() throws Exception {
        final int a = this.a;
        final String s = this.s;
        final User user = this.user;
        // 直接修改编译报错
//        a = 2;
//        s = "hello world";
//        user = new User(2, "rose");
        user.id = 2;
        System.out.println(user.id);
        // 方法传递也会编译报错
//        a = fun(a);
    }

    private int fun(int num) {
       return num * 2;
    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}