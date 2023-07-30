package com.lizza.Base;

import org.junit.Test;

/**
 * @Desc: for 循环测试
 * @author: lizza.liu
 * @date: 2022-02-28
 */
public class ForTests {

    // 测试 i 初始值小于跳出条件, 是否会执行
    @Test
    public void test1() {
        // 不会执行
        for (int i = 0; i < 1; i++) {
            System.out.println("exec...");
        }
    }

    /**
     * 测试 for 循环中 return 是否会提前中断主线程
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (i == 7) {
                return;
            }
            System.out.println("i: " + i);
        }
        System.out.println("finished!");
    }

    /**
     * 多层 for 循环, return 会跳出所有循环
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    return;
                }
            }
            System.out.println("first i: " + i);
        }
        System.out.println("finished!");
    }
}
