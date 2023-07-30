package com.lizza.publisher;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Publisher_1 {

    @Test
    public void test1() {
        // 空的publisher
        Mono<Object> empty = Mono.empty();
        empty.subscribe(System.out::println);
    }

    @Test
    public void test2() {
        Mono<Object> one = Mono.just("hello");
        one.subscribe(System.out::println);
    }

    @Test
    public void test3() {
        Flux<Integer> range = Flux.range(3, 7);
        range.subscribe(System.out::println);
    }
}
