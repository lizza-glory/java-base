package com.lizza.Queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：可以存储各种类型元素的容器，遵守先进先出的原则，只能在队首取出元素，只能在队尾插入元素
 *
 * @author lt
 * @version v1.0
 * @date 2019年6月15日
 */
public class Queue_1 {

    @Test
    public void test() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            // 队首入队
            q.add(i);
        }
        System.out.println(q);
        for (int i = 0; i < 6; i++) {
            // 队尾出队
            System.out.println(q.poll());
        }
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
    }
}
