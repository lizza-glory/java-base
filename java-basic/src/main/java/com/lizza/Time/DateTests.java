package com.lizza.Time;

import org.junit.Test;

import java.util.Date;

public class DateTests {

    @Test
    public void test1() throws Exception {
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1.equals(date2));
        System.out.println(date1 == date2);
    }

    @Test
    public void test2() throws Exception {
        // 获取美国时间
    }
}
