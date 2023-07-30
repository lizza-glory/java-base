package com.lizza.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTests {

    public List<User> init() {
        List<User> list = Lists.newArrayList();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= i; j++) {
                list.add(new User(i, "info-" + j));

            }
        }
        return list;
    }

    @Test
    public void test1() throws Exception {
        Map<String, List<Integer>> map = Maps.newHashMap();
        map.computeIfAbsent("a", k -> Lists.newArrayList(1, 2, 3));
        map.computeIfAbsent("a", k -> Lists.newArrayList(1, 2, 3))
           .addAll(Lists.newArrayList(4, 5, 6));
        System.out.println(map);
    }

    /**
     * 测试添加 Map<Integer, List<String>> 类型的数据
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        List<User> list = init();
        Map<Integer, List<String>> map = Maps.newHashMap();
        for (User user : list) {
            map.computeIfAbsent(user.getId(), e -> new ArrayList<>())
                    .add(user.getInfo());
        }
        System.out.println(JSONObject.toJSONString(map));
    }

    /**
     * 测试添加 Map<Integer, List<String>> 类型的数据
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        List<User> list = init();
        Map<Integer, List<String>> map = Maps.newHashMap();
        for (User user : list) {
            map.putIfAbsent(user.getId(), new ArrayList<>())
                    .add(user.getInfo());
        }
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void test4() throws Exception {
        List<User> list = init();
        list.add(new User(100, null));
        System.out.println(list);
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(User::getId, User::getInfo, (o, n) -> n));
        System.out.println(map);
    }
}
