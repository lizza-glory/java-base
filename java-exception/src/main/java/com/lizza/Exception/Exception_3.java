package com.lizza.Exception;

import cn.hutool.core.date.format.FastDateFormat;
import org.junit.Test;

import java.util.Date;

/**
 * 验证: 内层方法中异常没有抛出时, 外层方法无法捕捉到
 *
 */
public class Exception_3 {

    public void inner() {
        System.out.println("inner method");
        Integer.parseInt("1530403200000");
    }

    public void outer() {
        try {
            System.out.println("outer method");
            inner();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    @Test
    public void test1() throws Exception {
        outer();
    }

    public static void main(String[] args){
        String s = "1530403200000";
        try {
            Date date = FastDateFormat
                    .getInstance("yyyy-MM-dd HH:mm:ss")
                    .parse(s);
            System.out.println("date: " + date);
        } catch (NumberFormatException e) {
            Date date = new Date(Long.parseLong(s));
            System.out.println("final: " + date);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test3() throws Exception {
        System.out.println(Integer.MAX_VALUE);
        System.out.println("1530403200000");
        System.out.println(Integer.parseInt("1530403200000"));
    }
}
