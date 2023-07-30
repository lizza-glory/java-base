package com.lizza.operator.fliter;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @Desc: 定期发射Observable最近发射的数据项
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Sample {

    @Test
    public void test1() throws InterruptedException {
        Observable.range(0, 10)
                .sample(1, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("observable finished");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("observable exception: " + e);
                    }

                    @Override
                    public void onNext(Integer num) {
                        System.out.println("observable response: " + num);
                    }
                });
        Thread.currentThread().join();
    }
}
