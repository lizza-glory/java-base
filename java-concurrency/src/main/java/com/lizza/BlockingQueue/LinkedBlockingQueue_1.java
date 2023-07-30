package com.lizza.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-12-20
 */
public class LinkedBlockingQueue_1 {

    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        int count = 0;
        while (count <= 10)
            queue.put(count++);
    }
}
