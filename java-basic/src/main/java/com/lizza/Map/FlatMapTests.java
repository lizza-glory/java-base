package com.lizza.Map;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTests {

    @Test
    public void test1() throws Exception {
        Map<String, List<Integer>> map = Maps.newHashMap();
        map.computeIfAbsent("A", e -> Lists.newArrayList()).addAll(Lists.newArrayList(1, 2, 3));
        map.computeIfAbsent("B", e -> Lists.newArrayList()).addAll(Lists.newArrayList(4, 5, 6));
        map.computeIfAbsent("C", e -> Lists.newArrayList()).addAll(Lists.newArrayList(7, 8, 9));

        List<String> list = Lists.newArrayList("A", "B", "D");
        List<Integer> collect = list.stream().map(map::get)
                .filter(CollectionUtil::isNotEmpty)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2() throws Exception {
        System.out.println("{\"newUserId\":2060132192,\"oldUserId\":2000000000,\"signUpEmail\":\"ghx882@yopmail.com\"}");
    }

    @Test
    public void test3() throws Exception {
        System.out.println(2000087847 % 128);
    }
}
