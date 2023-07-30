package com.lizza.DelayQueue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Message implements Delayed {

    private long time;
    private String text;

    public Message(long time, String text, TimeUnit unit) {
        this.time = unit.toMillis(time) + System.currentTimeMillis();
        this.text = text;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        // 过期时间长的放置在队列尾部, 过期时间短的放置在队列头
        return Long.compare(this.getDelay(TimeUnit.MICROSECONDS), o.getDelay(TimeUnit.MICROSECONDS));
    }

    @Override
    public String toString() {
        return "{\"time\": " + time + ", \"formatTime\": \"" + LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()) + "\", \"text\": \"" + text + "\"}";
    }
}
