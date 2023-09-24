package com.lizza.Stream;

import org.junit.Test;

import java.util.stream.IntStream;

public class IntStreamTests {

    @Test
    public void test1() throws Exception {
        IntStream.of(10).boxed().forEach(System.out::println);
    }
}
