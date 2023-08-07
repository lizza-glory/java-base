package com.lizza.Time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Stream;

/**
 * 世界时间/多地区时间处理
 * 1. https://www.cnblogs.com/yourbatman/p/14307194.html
 * 2. https://mp.weixin.qq.com/s/VdoQt88JfjPJTL9XgohZJQ
 */
public class UniversalTimeTests {

    @Test
    public void test1() throws Exception {
        // 获取所有时区
        // java.time.format.ZoneName.zidMap
        Stream.of(TimeZone.getAvailableIDs()).forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("可用时区的数量: " + zoneIds.size());
        Stream.of(zoneIds).forEach(System.out::println);
    }

    /**
     * 根据指定时区来格式化指定时间
     */
    @Test
    public void test3() throws Exception {
        // 该时间从 DB 获得
        Date date = new Date();

        // 将 Instant 转换为 LocalDate，需要传入指定的时区对象
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
        ZoneId zoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(-5));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(zoneId);
        String formattedDate = zonedDateTime.format(formatter);

        System.out.println("转换后的时间: " + formattedDate);
    }

    @Test
    public void test4() throws Exception {
        // 获取当前时间
        ZonedDateTime now = ZonedDateTime.now();

        // 指定西五区的时区
        ZoneId westZoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(-5));

        // 将当前时间转换为西五区的时间
        ZonedDateTime westNow = now.withZoneSameInstant(westZoneId);

        // 格式化西五区的时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = westNow.format(formatter);

        System.out.println("西五区的时间: " + formattedDateTime);

    }
}
