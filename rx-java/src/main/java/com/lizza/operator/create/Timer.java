package com.lizza.operator.create;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @Desc: 创建一个Observable，它在一个给定的延迟后发射一个特殊的值。
 * todo
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Timer {

    @Test
    public void test1() throws InterruptedException {
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {

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
