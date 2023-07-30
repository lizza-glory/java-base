package com.lizza.publisher;

import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-09-06
 */
public class Handle_1 {

    @Test
    public void test1() {
        Flux<Object> seq = Flux.range(0, 10)
                .handle((i, sink) -> {
                    if (i % 2 == 0) {
                        sink.next(i);
                    }
                });
        seq.subscribe(System.out::println);
    }
}
