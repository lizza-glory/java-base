package com.lizza.StreamApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekTests {

    @Test
    public void test1() throws Exception {
        List<String> list = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> {
                    e = e + ">>>";
                })
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test2() throws Exception {
        List<User> list = Stream.of(1, 2, 3, 4, 5).map(e -> User.builder().id(e.toString()).name("u-" + e).build()).collect(Collectors.toList());
        System.out.println(list);
        List<User> users = list.stream().peek(e -> e.setId("id-" + e.getId())).collect(Collectors.toList());
        System.out.println(users);
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String id;
        private String name;
    }
}
