package com.lizza.StreamApi;

import org.junit.Test;

import java.util.stream.IntStream;

public class SkipTests {

    @Test
    public void test1() throws Exception {
        IntStream.range(1, 10).boxed().skip(1).forEach(System.out::println);
    }
}
