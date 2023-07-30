package com.lizza.Map.HashMap;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-21
 */
public class HashMapTests {

    // 测试 Long 类型的数据是否能够做 key
    @Test
    public void test1() {
        HashMap<Long, Object> map = Maps.newHashMap();
        Long l1 = new Long(1);
        Long l2 = new Long(1);
        map.put(l1, 1);
        map.put(l2, 2);

        System.out.println(map.get(l1));
        System.out.println(map.get(l2));
    }
}
