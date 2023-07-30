package com.lizza.Array;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTests {

    @Test
    public void test1() throws Exception {
        List<String> list = Lists.newArrayList("1", "2", "3");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Long.parseLong(list.get(0)));
    }

    @Test
    public void test3() throws Exception {
        String s1 = "[\"2022-08-01\",\"长期\"]";
        String s2 = "[\"2022-08-01\",\"2022-08-31\"]";
        String s3 = "[\"2022-08-01\",\"2022-08.31\"]";
        String s4 = "2022.10.13-2032.10.13";
        System.out.println(JSONObject.parseArray(s1, String.class));
        System.out.println(JSONObject.parseArray(s2, String.class));
        for (String item : JSONObject.parseArray(s3, String.class)) {
            System.out.println(DateUtil.parse(item, "yyyy-MM-dd"));
        }
        System.out.println(JSONObject.parseArray(s4, String.class));
    }
}
