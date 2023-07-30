package com.lizza.operator.create;

import rx.Observable;
import rx.functions.Func0;

import java.util.Random;

/**
 * @Desc: todo defer 用法
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Defer {

    public static void main(String[] args){
        Observable observable = Observable.defer((Func0) () ->
                new Random().nextInt(100));

        observable.doOnNext(o -> System.out.println("accept observable response: " + o));

    }
}
