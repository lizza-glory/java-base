package com.lizza.operator.transform;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @Desc: FlatMap将一个发射数据的Observable变换为多个Observables，然后将它们发射的数据合并后放进一个单独的Observable
 * todo
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class FlatMap {

    @Test
    public void test1() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .flatMap(new Func1<Integer, Observable<?>>() {
                    @Override
                    public Observable<?> call(Integer num) {
                        return Observable.just(num);
                    }
                })
                .subscribe(new Subscriber<Object>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("observable finished");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("observable exception: " + e);
                    }

                    @Override
                    public void onNext(Object obj) {
                        System.out.println("observable response: " + obj);
                    }
                });
    }
}
