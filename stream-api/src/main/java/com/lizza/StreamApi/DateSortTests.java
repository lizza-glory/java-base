package com.lizza.StreamApi;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;

public class DateSortTests {

    /**
     * 测试 Date 排序
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        // 升序
        Lists.newArrayList(
                Date.from(LocalDate.of(2012, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2022, 3, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2018, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant())
        ).stream().sorted().forEach(System.out::println);
        System.out.println();
        // 降序
        Lists.newArrayList(
                Date.from(LocalDate.of(2012, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2022, 3, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2018, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant())
        ).stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        // 取最小值
        Lists.newArrayList(
                Date.from(LocalDate.of(2012, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2022, 3, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2018, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant())
        ).stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);
        System.out.println();
        // 降序
        Lists.newArrayList(
                Date.from(LocalDate.of(2012, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2022, 3, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.of(2018, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant())
        ).stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }
}
