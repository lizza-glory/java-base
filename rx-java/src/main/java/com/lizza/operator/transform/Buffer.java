package com.lizza.operator.transform;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.List;

/**
 * @Desc: Buffer: 定期收集Observable的数据放进一个数据包裹，然后发射这些数据包裹，而不是一次发射一个值。
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Buffer {

    @Test
    public void test1() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .buffer(3)
                .subscribe(new Subscriber<List<Integer>>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("observable finished");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("observable exception: " + e);
                    }

                    @Override
                    public void onNext(List<Integer> list) {
                        System.out.println("observable response: " + list);
                    }
        });
    }
}
