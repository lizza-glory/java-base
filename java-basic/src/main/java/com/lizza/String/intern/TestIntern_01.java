package com.lizza.String.intern;

/**
 * 测试String的intern方法
 * 1. String中的==并不是单纯意义上的去比较值是否相等, 例如:
 *      String s1 = "计算机";
 *      String s2 = "计算机";
 *      System.out.println(s1 == s2);
 *      String s3 = new String("计算机");
 *      System.out.println(s1.equals(s3));
 *      输出true, false
 */
public class TestIntern_01 {

    public static void main(String[] args){
        String s1 = "计算机";
        String s2 = "计算机";
        System.out.println("s1 == s2: " + (s1 == s2));

        String s3 = new String("计算机");
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + (s1.equals(s3)));

        String s4 = new String("计算机");
        System.out.println("s3 == s4: " + (s3 == s4));
        System.out.println("s3.intern() == s4.intern(): " + (s3.intern() == s4.intern()));

        String s5 = new StringBuilder("软件工程").append("学院").toString();
        System.out.println("s5.intern() == s5: " + (s5.intern() == s5));

        String s6 = new String("计算机");
        System.out.println("s6.intern() == s6: " + (s6.intern() == s6));
    }
}
