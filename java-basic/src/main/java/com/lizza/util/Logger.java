package com.lizza.util;

import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义的日志类
 */
public class Logger {

    private static final Pattern PATTERN = Pattern.compile("\\{\\}");

    public static void info(String pattern, Object... args) {
        Matcher matcher = PATTERN.matcher(pattern);
        int index = 0;
        while (matcher.find()) {
            pattern = pattern.replaceFirst("\\{\\}", "{" + index++ + "}");
        }
        String time = "\033[34m[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] ";
        String name = "\033[35m[" + Thread.currentThread().getName()+ "] \033[0m";
        String message = time + name + MessageFormat.format(pattern, args);
        System.out.println(message);
    }

    @Test
    public void test1() throws Exception {
        info("id: {}, name: {}", 12, "小李子");
        info("hello world");
        System.out.println("\033[34m" + "李四" + "\033[34m \n");
    }

    @Test
    public void test2() throws Exception {
        String msg = "id: {}, name: {}";
    }
}
