package com.lizza.subscriber;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class Subscriber_1 {

    @Test
    public void test1() {
        Flux<Integer> publisher = Flux.range(0, 5)
                .map(i -> {
                    if (i == 3) {
                        throw new RuntimeException("4 is error");
                    }
                    return i;
                });
        publisher.subscribe(System.out::println, e -> System.out.println("error: " + e));
    }

    @Test
    public void test2() {
        Flux<Integer> publisher = Flux.range(0, 5);
        publisher.subscribe(System.out::println,
                e -> System.out.println("error: " + e),
                () -> System.out.println("finished!"));
    }

    @Test
    public void test3() {
        Flux<Integer> publisher = Flux.range(0, 10);
        publisher.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                subscription.request(5);
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println(value);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("finished!");
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                System.out.println("error: " + throwable.getLocalizedMessage());
            }
        });
    }
}
