package com.lizza.ArrayList;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * 并发情况下, ArrayList 并发安全问题
 */
public class ArrayListSafe {

    /**
     * 并发的向 Arraylist 中写入元素
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        System.out.println(1000062564%128);
    }
}
