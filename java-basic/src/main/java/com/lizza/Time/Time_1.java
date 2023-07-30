package com.lizza.Time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-01-13
 */
public class Time_1 {

    @Test
    public void test1() {
        long time1 = System.currentTimeMillis();
        long time2 = System.nanoTime()/100;
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(time2), ZoneId.systemDefault()));
    }
}
