package com.lizza.DelayQueue;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列
 * 要使用延迟队列, 延迟队列的元素需要实现 Delayed 的接口, 接口中有两个方法需要重写
 * 1. getDelay: 用来获取过期时间, 传入的是时间单位
 * 2. compareTo: 用来判断是否过期, 过期规则需要自己重写
 *
 */
public class DelayQueue_1 {

    @Test
    public void test1() throws Exception {
        DelayQueue<Message> queue = new DelayQueue<>();
        for (long i = 1; i <= 10; i++) {
            queue.add(new Message(i, "延迟时间: " + i + "s", TimeUnit.SECONDS));
        }
        while (queue.size() > 0) {
            System.out.println(
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                    ": " + queue.take());
        }
    }
}
