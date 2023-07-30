package com.lizza.error;

import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-09-06
 */
public class Error_1 {

    @Test
    public void test1() {
        Flux.range(0, 10)
                .map(i -> {
                    if (i == 5) {
                        throw new RuntimeException("5 is error");
                    }
                    return i;
                })
                .onErrorReturn(-1)
                .subscribe(System.out::println);
    }
}
