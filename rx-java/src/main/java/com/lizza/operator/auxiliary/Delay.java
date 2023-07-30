package com.lizza.operator.auxiliary;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Delay {

    @Test
    public void test1() throws InterruptedException {
        Observable.range(0, 5)
                .delay(3, TimeUnit.SECONDS)
//                .timeout(2, TimeUnit.SECONDS)
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
