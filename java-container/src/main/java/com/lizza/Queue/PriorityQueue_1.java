package com.lizza.Queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * PriorityQueue 用于实现优先级队列, 优先级可以通过重写 Comparator 来实现
 */
public class PriorityQueue_1 {

    public static void main(String[] args){
        PriorityQueue<Integer> queue = new PriorityQueue((m, n) -> - ((int) m - (int) n));

        for (int i = 0; i < 30; i++) {
            int num = new Random().nextInt(30);
            queue.add(num);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
