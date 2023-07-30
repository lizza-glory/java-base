package com.lizza.publisher;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-09-06
 */
public class Create_1 {

    @Test
    public void test1() {
        Flux.create(new Consumer<FluxSink<? extends Object>>() {
            @Override
            public void accept(FluxSink<?> fluxSink) {
                fluxSink.complete();
            }
        });
    }
}
