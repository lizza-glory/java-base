package com.lizza.Time;

import com.lizza.util.DateUtils;
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
        Date date1 = DateUtils.buildDateBy(2023, 9);
        Date date2 = DateUtils.buildDateBy(2023, 9);
        System.out.println(DateUtils.format(date1, "yyyy-MM-dd HH::mm:ss"));
        System.out.println(date1.equals(date2));
    }
}
