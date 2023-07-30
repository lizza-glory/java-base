package com.lizza.operator.fliter;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @Desc: 仅在过了一段指定的时间还没发射数据时才发射一个数据
 * todo
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Debounce {

    @Test
    public void test1() throws InterruptedException {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .debounce(1, TimeUnit.SECONDS)
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
