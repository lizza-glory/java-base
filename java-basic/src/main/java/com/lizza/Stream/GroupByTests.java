package com.lizza.Stream;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTests {

    List<User> users = Arrays.asList(
            new User("Alice", 10, "Female"),
            new User("Bob", 15, "Male"),
            new User("Charlie", 20, "Male"),
            new User("Amy", 25, "Female"),
            new User("Eva", 30, "Female"),
            new User("David", 35, "Male")
    );

    @Test
    public void test1() throws Exception {
        Map<String, List<User>> list = users.stream()
                .collect(Collectors.groupingBy(
                        User::getSex,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                items -> {
                                    items.sort(Comparator.comparingInt(User::getAge));
                                    return items;
                                })
                        )
                );

        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list = users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .skip(1)
                .map(User::getAge)
                .collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void test3() throws Exception {
        Map<String, List<Student>> map = users.stream().collect(Collectors.groupingBy(
                User::getSex,
                Collectors.mapping(
                        e -> {
                            Student student = new Student();
                            student.setName(e.getName());
                            student.setAge(e.getAge());
                            student.setSex(e.getSex());

                            return student;
                        },
                        Collectors.toList()
                )
        ));
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        private Integer age;
        private String sex;
    }

    @Data
    public static class Student {
        private String name;
        private Integer age;
        private String sex;
    }
}
