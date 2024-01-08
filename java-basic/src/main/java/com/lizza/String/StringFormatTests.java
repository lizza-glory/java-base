package com.lizza.String;

import com.google.common.base.Strings;
import org.junit.Test;

import java.text.MessageFormat;

public class StringFormatTests {

    @Test
    public void test1() throws Exception {
        String msg = "%s发货须知: 发货前请携带%s";
        System.out.println(String.format(msg, "1. ", "鞋盒, 鞋带, 鞋帮子"));
        System.out.println(String.format(msg, Strings.nullToEmpty(null), "鞋盒, 鞋带, 鞋帮子"));
    }

    /**
     * 测试 String.format 参数个数
     */
    @Test
    public void test2() throws Exception {
        String msg = "姓名: %s, 性别: %s";
        System.out.println(String.format(msg, "张三", "男"));
        // 入参多了是 ok 的
        System.out.println(String.format(msg, "张三", "男", 25));
        // 入参少了就会报错: java.util.MissingFormatArgumentException: Format specifier '%s'
        System.out.println(String.format(msg, "张三"));
    }

    /**
     * 测试 String.format 参数个数
     */
    @Test
    public void test3() throws Exception {
        String msg = "姓名: {0}, 性别: {1}";
        System.out.println(MessageFormat.format(msg, "张三", "男"));
        // 入参多了是 ok 的
        System.out.println(MessageFormat.format(msg, "张三", "男", 25));
        // 入参少了就会报错: java.util.MissingFormatArgumentException: Format specifier '%s'
        System.out.println(MessageFormat.format(msg, "张三"));
    }

    @Test
    public void test4() throws Exception {
        System.out.println(2000155829%128);
    }
}
