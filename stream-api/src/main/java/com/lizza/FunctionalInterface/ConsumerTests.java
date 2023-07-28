package com.lizza.FunctionalInterface;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class ConsumerTests {

    @Test
    public void test1() throws Exception {
        Integer num = new Integer(3);
        Optional.of(num).ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    public void print(int num) {
        System.out.println("num: " + num);
    }
}
