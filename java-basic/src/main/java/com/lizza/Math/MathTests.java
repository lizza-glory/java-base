package com.lizza.Math;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

import java.util.Random;

/**
 *
 */
public class MathTests {

    @Test
    public void test1() {
        // -1
        System.out.println(Math.round(-1.5));
        // -2
        System.out.println(Math.floor(-1.5));
        // -1
        System.out.println(Math.ceil(-1.5));
    }

    @Test
    public void test2() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextLong());
        }
    }

    @Test
    public void test3() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println(RandomUtil.randomLong(20, 20000));
        }
    }
}
