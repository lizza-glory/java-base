package com.lizza.String;

import com.google.common.base.Strings;
import org.junit.Test;

public class StringFormatTests {

    @Test
    public void test1() throws Exception {
        String msg = "%s发货须知: 发货前请携带%s";
        System.out.println(String.format(msg, "1. ", "鞋盒, 鞋带, 鞋帮子"));
        System.out.println(String.format(msg, Strings.nullToEmpty(null), "鞋盒, 鞋带, 鞋帮子"));
    }
}
