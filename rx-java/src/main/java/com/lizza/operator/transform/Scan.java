package com.lizza.operator.transform;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * @Desc: 连续地对数据序列的每一项应用一个函数，然后连续发射结果
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Scan {

    @Test
    public void test1() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer i1, Integer i2) {
                        return i1 + i2;
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
