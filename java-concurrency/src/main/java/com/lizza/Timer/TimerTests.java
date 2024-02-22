package com.lizza.Timer;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 时间轮: Timer 实现
 */
public class TimerTests {

    // 在指定时间执行单次任务
    @Test
    public void test1() throws Exception {
        Date date = Date.from(LocalDateTime.now().plusSeconds(5L)
                .atZone(ZoneId.systemDefault())
                .toInstant());
        System.out.println("time: " + LocalTime.now());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time: " + LocalTime.now() + ", run after 5 seconds.");
            }
        }, date);
        Thread.currentThread().join();
    }

    // 延迟 5 秒后执行
    @Test
    public void test2() throws Exception {
        System.out.println("time: " + LocalTime.now());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time: " + LocalTime.now() + ", run after 5 seconds.");
            }
        }, 5000L);
        Thread.currentThread().join();
    }

    // 程序启动 1 秒后, 开始执行周期性任务, 1 秒执行一次
    @Test
    public void test3() throws Exception {
        System.out.println("time: " + LocalTime.now());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time: " + LocalTime.now() + ", run task.");
            }
        }, 1000L, 1000L);
        Thread.currentThread().join();
    }

    // 程序启动后, 立即开始执行周期性任务, 1 秒执行一次
    @Test
    public void test4() throws Exception {
        System.out.println("time: " + LocalTime.now());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time: " + LocalTime.now() + ", run task.");
            }
        }, 0L, 1000L);
        Thread.currentThread().join();
    }

    @Test
    public void test5() throws Exception {
        System.out.println(TimeUnit.MINUTES.toMillis(5));
    }
}
