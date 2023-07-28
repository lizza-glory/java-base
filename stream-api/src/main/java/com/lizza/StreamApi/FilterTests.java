package com.lizza.StreamApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试一下, stream filter 之后返回的集合中的元素, 以及集合是否是原来的对象
 */
public class FilterTests {

    @Test
    public void test1() throws Exception {
        List<User> list = Stream.of(1, 2, 3, 4, 5).map(e -> User.builder().id(e).name("u-" + e).build()).collect(Collectors.toList());
        System.out.println("原始集合: " + list.hashCode());
        List<User> list2 = list.stream().filter(e -> e.getId() % 2 == 0).collect(Collectors.toList());
        System.out.println("新集合: " + list2.hashCode());
        list.forEach(e -> System.out.println("原始集合元素: " + e.hashCode()));
        list2.forEach(e -> System.out.println("新集合元素: " + e.hashCode()));
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private Integer id;
        private String name;
    }
}
