package com.lizza.Stream;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTests {

    @Test
    public void test1() throws Exception {
        List<User> list = IntStream.range(1, 10)
                                      .mapToObj(i -> User.builder().name("user" + i)
                                                         .birthday(Date.from(LocalDate.now().minusDays(i).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                                                         .build())
                                      .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("--------");
        System.out.println(check(list));

    }

    public User check(List<User> list) {
        List<User> users = list.stream().sorted(Comparator.comparing(User::getBirthday).reversed()).collect(Collectors.toList());
        for(User user : users) {
            Date protectDate = DateUtil.offsetDay(user.birthday, 5);
            if (protectDate.before(DateUtil.date())) {
                // 过期, 直接中断计算
                return user;
            }
        }
        return null;
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list1 = IntStream.range(1, 10).mapToObj(Integer::new).collect(Collectors.toList());
        List<Integer> list2 = list1.stream().filter(e -> e != 3).collect(Collectors.toList());
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
    }
}
