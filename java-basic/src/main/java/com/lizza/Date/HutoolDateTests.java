package com.lizza.Date;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HutoolDateTests {

    @Test
    public void test1() throws Exception {
        Date start = Date.from(LocalDate.of(2012, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(LocalDate.of(2022, 3, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        int age = DateUtil.age(end, start);
        System.out.println(age);
    }

    @Test
    public void test2() throws Exception {
        String time = "2004-05-03T17:30:08+08:00";
        Date date = Date.from(Instant.parse(time));
        time = cn.hutool.core.date.DateUtil.formatDateTime(date);
        System.out.println(time);
    }
}
