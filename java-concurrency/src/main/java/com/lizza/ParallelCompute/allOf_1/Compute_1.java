package com.lizza.ParallelCompute.allOf_1;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-13
 */
public class Compute_1 extends AbstractComputer {

    @Override
    String compute() throws Exception {
        Thread.sleep(1000);
        return "Compute_1 compute";
    }

    @Override
    String name() {
        return "Compute_1";
    }
}
