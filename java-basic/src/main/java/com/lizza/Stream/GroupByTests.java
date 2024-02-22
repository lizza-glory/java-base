package com.lizza.Stream;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTests {

    List<User> users = Arrays.asList(
            new User("Alice", 10, "Female", LocalDate.of(2023, 12,2)),
            new User("Bob", 15, "Male", LocalDate.of(2009, 9,12)),
            new User("Charlie", 20, "Male", LocalDate.of(2024, 1,22)),
            new User("Amy", 25, "Female", LocalDate.of(2017, 8,3)),
            new User("Eva", 30, "Female", LocalDate.of(2022, 7,5)),
            new User("David", 35, "Male", LocalDate.of(2021, 12,2)),
            new User("Eva", 30, "Female", LocalDate.of(2024, 7,5)),
            new User("David", 35, "Male", LocalDate.of(2024, 12,2))
    );

    /**
     * 对象数组按照 int 字段排序, 去重
     */
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

    /**
     * 按照 int 类型字段倒排
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        List<User> list = users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .skip(1)
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

    /**
     * 按照 name 去重, 按照 modifyTime 排序
     * minBy: 按照时间顺序排序, 时间最新的排在最后面
     * maxBy: 按照时间顺序排序, 时间最新的排在最前面
     */
    @Test
    public void test4() throws Exception {
        List<User> list = new ArrayList<>(users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        Function.identity(),
                        BinaryOperator.maxBy(
                                Comparator.comparing(
                                        User::getModifyTime
                                )
                        )
                ))
                .values());
        System.out.println(JSONObject.toJSONString(
                list,
                SerializerFeature.PrettyFormat
        ));
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        private Integer age;
        private String sex;
        private LocalDate modifyTime;
    }

    @Data
    public static class Student {
        private String name;
        private Integer age;
        private String sex;
    }

    @Test
    public void test99() throws Exception {
        System.out.println(2060272634%128);
    }
}
