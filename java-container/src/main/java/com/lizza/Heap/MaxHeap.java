package com.lizza.Heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先级队列: 默认是小顶堆, 可以自己实现 Comparator 接口
 */
public class MaxHeap {

    // 小顶堆
    @Test
    public void test1() throws Exception {
        int[] array = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1, 5, 3, 9};
        PriorityQueue queue = new PriorityQueue();
        for (int num : array) {
            queue.add(num);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // 大顶堆
    @Test
    public void test2() throws Exception {
        int[] array = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1, 5, 3, 9};
        PriorityQueue queue = new PriorityQueue(Comparator.comparingInt(i -> -(int)i));
        for (int num : array) {
            queue.add(num);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
