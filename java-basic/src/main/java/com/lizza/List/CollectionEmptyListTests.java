package com.lizza.List;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class CollectionEmptyListTests {

    @Test
    public void test1() throws Exception {
        List<Integer> list = Collections.emptyList();
        System.out.println(list.getClass());
        list.add(1);
    }
}
