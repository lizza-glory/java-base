package com.lizza.operator.auxiliary;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * @Desc: 注册一个动作作为原始Observable生命周期事件的一种占位符
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Do {

    @Test
    public void test1() throws InterruptedException {
        Observable.range(0, 5)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer num) {
                        if (num > 3) {
                            throw new RuntimeException("need more smaller num...");
                        }
                    }
                })
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
