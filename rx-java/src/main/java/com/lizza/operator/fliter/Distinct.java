package com.lizza.operator.fliter;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @Desc: 过滤掉重复的数据项
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Distinct {

    @Test
    public void test1() throws InterruptedException {
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct()
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
    }
}
