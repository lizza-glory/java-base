package com.lizza.String.equals;

/**
 * String 的 equals 方法底层的实现是遍历 char 数组去比较
 */
public class Equals_1 {

    public static void main(String[] args){
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));
    }
}
