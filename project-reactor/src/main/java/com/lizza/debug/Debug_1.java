package com.lizza.debug;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-09-06
 */
public class Debug_1 {

    @Test
    public void test1() {
        Flux.range(0, 10)
                .map(i -> {
                    if (i == 5) {
                        throw new RuntimeException("5 is error");
                    }
                    return i;
                })
                .subscribe(System.out::println);
    }

    @Test
    public void test2() {
        Hooks.onOperatorDebug();
        Flux.range(0, 10)
                .map(i -> {
                    if (i == 5) {
                        throw new RuntimeException("5 is error");
                    }
                    return i;
                })
                .subscribe(System.out::println);
    }
}
