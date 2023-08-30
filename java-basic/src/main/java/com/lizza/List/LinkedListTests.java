package com.lizza.List;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;

/**
 * 双向链表
 */
public class LinkedListTests {

    @Test
    public void test1() throws Exception {
        LinkedList<Date> list = new LinkedList<>();
        list.add(DateUtil.parse("2023-08-03", "yyyy-MM-dd"));
        list.add(DateUtil.parse("2023-08-19", "yyyy-MM-dd"));
        list.add(DateUtil.parse("2023-08-23", "yyyy-MM-dd"));
        list.add(DateUtil.parse("2023-08-26", "yyyy-MM-dd"));
        list.add(DateUtil.parse("2023-08-30", "yyyy-MM-dd"));
        
        list.forEach(e -> System.out.println(DateUtil.format(e, "yyyy-MM-dd")));

        DateTime target = DateUtil.parse("2023-08-26", "yyyy-MM-dd");
        System.out.println(list.indexOf(target));
        System.out.println(list);
    }
}
