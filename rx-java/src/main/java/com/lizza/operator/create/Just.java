package com.lizza.operator.create;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @Desc: 创建一个发射指定值的Observable
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Just {

    @Test
    public void test1() {
        Observable.just(1, 2, 3).subscribe(new Subscriber<Integer>() {

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
    }
}
