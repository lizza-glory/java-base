package com.lizza.publisher;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Generate_1 {

    @Test
    public void test1() {
        Flux<Object> seq = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                }
        );
        seq.subscribe(System.out::println);
    }

    @Test
    public void test2() {
        Flux<Object> seq = Flux.generate(
                AtomicInteger::new,
                (state, sink) -> {
                    int num = state.getAndIncrement();
                    sink.next("3 x " + num + " = " + 3 * num);
                    if (num == 10) {
                        sink.complete();
                    }
                    return state;
                }
        );
        seq.subscribe(System.out::println);
    }
}
