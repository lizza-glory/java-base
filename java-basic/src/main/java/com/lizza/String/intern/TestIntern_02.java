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
public class TestIntern_02 {

    public static void main(String[] args){
        String s1 = new String("计算机");
        s1.intern();
        String s2 = "计算机";
        System.out.println("s1 == s2: " + (s1 == s2));

        String s3 = new String("计算机") + new String("科学");
        String s4 = "计算机科学";
        // 上移一行, 变为false
        s3.intern();
        System.out.println("s3 == s4: " + (s3 == s4));
    }
}
