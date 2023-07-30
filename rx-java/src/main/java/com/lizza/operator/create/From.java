package com.lizza.operator.create;

import org.junit.Test;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

/**
 * @Desc: 将一个数组转换为 observable
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class From {

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.from(list);
        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer e) {
                System.out.println("observable response: " + e);
            }
        }, new Action1<Throwable>() {

            @Override
            public void call(Throwable throwable) {
                System.out.println("observable exception: " + throwable);
            }
        }, new Action0() {

            @Override
            public void call() {
                System.out.println("observable finished...");
            }
        });
    }

    @Test
    public void test2() {
        Observable<Integer> observable = Observable.fromCallable(() -> 1);
        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer e) {
                System.out.println("observable response: " + e);
            }
        }, new Action1<Throwable>() {

            @Override
            public void call(Throwable throwable) {
                System.out.println("observable exception: " + throwable);
            }
        }, new Action0() {

            @Override
            public void call() {
                System.out.println("observable finished...");
            }
        });
    }
}
