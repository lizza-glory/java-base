package com.lizza.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class Flux_1 {

    @Test
    public void test1() {
        // Publisher
        Flux<Integer> seq = Flux.just(1, 2, 3, 4, 5);
        // Subscriber
        seq.subscribe(System.out::println);
    }
}
