package com.lizza.Date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateTests {

    @Test
    public void test1() throws Exception {
        LocalDate date = LocalDate.of(2022, 10, 27);
        System.out.println(date);
        System.out.println(date.isBefore(LocalDate.now()));
    }

    @Test
    public void test2() throws Exception {
        // ISO 8601 标准的时间
        System.out.println(Instant.parse("2022-12-26T11:10:00.000Z").atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}
