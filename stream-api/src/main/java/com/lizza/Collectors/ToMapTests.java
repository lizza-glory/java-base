package com.lizza.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.lizza.GroupBy.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Collectors.toMap
 */
public class ToMapTests {

    @Test
    public void test1() throws Exception {
        Arrays.stream(Season.values()).forEach(System.out::println);
        HashMap<String, Integer> map = Arrays.stream(Season.values())
                .collect(Collectors.toMap(Season::getName, Season::getValue, (e1, e2) -> e1, Maps::newHashMap));
        System.out.println(map);
    }

    @Test
    public void test2() throws Exception {
        List<User> users = IntStream.range(1, 5)
                .mapToObj(e -> User.builder().id(e).info("info-" + e).build())
                .collect(Collectors.toList());
        Map<Integer, User> map = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (k1, k2) -> k2));
        System.out.println(JSONObject.toJSON(map));
    }
}
