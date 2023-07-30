package com.lizza.log;

import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-09-06
 */
public class Log_1 {

    @Test
    public void test1() {
        Flux.range(0, 3)
                .log()
                .subscribe(System.out::println);
    }
}
