package com.lizza.Map.HashMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Tests {

    /**
     * computeIfAbsent
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Map<String, List<Integer>> map = Maps.newHashMap();
        map.computeIfAbsent("a", e -> Lists.newArrayList(1, 2, 3))
                .addAll(Lists.newArrayList(1, 2, 3));
        map.computeIfAbsent("a", e -> Lists.newArrayList(4, 5, 6))
                .addAll(Lists.newArrayList(4, 5, 6));
        System.out.println(map);
    }
}
