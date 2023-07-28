package com.lizza.StreamApi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Stream API 练习
 */
public class Exercise {

    /**
     * 已知集合: 1, 3, 5, 7, 9, 11
     * 找出集合中大于 2 的元素, 然后将每个元素乘于 2, 然后忽略前两个元素
     * 然后再取前两个元素, 最后求和
     */
    @Test
    public void t_1() {
        List<Integer> array = Arrays.asList(1, 3, 5, 7, 9, 11);
        Optional<Integer> result = array.stream()
                .filter(e -> e > 2)
                .map(e -> e * 2)
                .skip(2)
                .limit(2)
                .reduce(Integer::sum);
        System.out.println(result);
    }
}
