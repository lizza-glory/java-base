package com.lizza.List;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListTest {

    @Test
    public void test1() throws Exception {
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        System.out.println(list);
        List<Integer> subList = list.subList(3, 5);
        System.out.println(subList);
        list.removeAll(subList);
        System.out.println(list);
        System.out.println(subList);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == 3) {
                iterator.remove();
            }
            System.out.println(value);
        }
    }

    /**
     * 快速失败模拟
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        for (Integer e : list) {
            if (e.equals(3)) {
                list.add(5);
            }
        }
    }

    /**
     * 快速失败模拟
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(3)) {
                list.add(5);
            }
        }
        System.out.println(list);
    }
}
