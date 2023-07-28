package com.lizza.GroupBy;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GroupByTests {

    public List<User> init() {
        List<User> list = Lists.newArrayList();
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                list.add(new User(i, "info-" + j));

            }
        }
        return list;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(JSONObject.toJSONString(
                init().stream().collect(
                        Collectors.groupingBy(User::getId)
                )));
    }
}
