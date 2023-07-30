package com.lizza.operator.create;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @Desc: 创建一个按固定时间间隔发射整数序列的Observable
 * todo
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Interval {

    @Test
    public void test1() throws InterruptedException {
        Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {

            @Override
            public void onCompleted() {
                System.out.println("observable finished");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observable exception: " + e);
            }

            @Override
            public void onNext(Long num) {
                System.out.println("observable response: " + num);
            }
        });
        Thread.currentThread().join();
    }
}
