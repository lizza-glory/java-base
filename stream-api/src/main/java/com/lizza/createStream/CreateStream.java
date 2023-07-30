package com.lizza.createStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建 stream
 */
public class CreateStream {

    @Test
    public void test1() throws Exception {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4});
        stream.forEach(System.out::println);
    }

    /**
     * java.util.stream.Stream#generate(java.util.function.Supplier) 可以创建一个无限的流
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Stream<Double> stream = Stream.generate(() -> Math.random()).limit(10);
        stream.forEach(System.out::println);
    }

    /**
     * java.util.stream.Stream#generate(java.util.function.Supplier) 可以创建一个无限的流
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        Stream<Integer> stream = Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer num) {
                return num;
            }
        }).limit(10);
        stream.forEach(System.out::println);
    }
}
