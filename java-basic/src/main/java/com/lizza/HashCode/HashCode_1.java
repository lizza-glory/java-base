package com.lizza.HashCode;

import com.google.common.collect.Maps;
import org.junit.Test;
import java.util.Map;

/**
 *
 */
public class HashCode_1 {

    @Test
    public void test1() {
        Map<User_1, Integer> map = Maps.newHashMap();
        User_1 user1 = User_1.builder().id(1).name("张三").build();
        User_1 user2 = User_1.builder().id(2).name("张三").build();
        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println(map);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
    }

    @Test
    public void test2() {
        Map<User_2, Integer> map = Maps.newHashMap();
        User_2 user1 = new User_2(1, "张三");
        User_2 user2 = new User_2(1, "张三");
        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println(map);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
    }
}
