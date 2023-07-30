package com.lizza.operator.transform;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @Desc: 对Observable发射的每一项数据应用一个函数，执行变换操作
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Map {

    @Test
    public void test1() {
        Observable.just(1, 2, 3)
                .map(new Func1<Integer, Object>() {

                    @Override
                    public Object call(Integer num) {
                        return "result-" + num;
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
