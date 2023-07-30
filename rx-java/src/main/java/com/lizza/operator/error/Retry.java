package com.lizza.operator.error;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @Desc: 如果原始Observable遇到错误，重新订阅它期望它能正常终止
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Retry {

    @Test
    public void test1() throws InterruptedException {
        // 创建 observable
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> observer) {
                if (!observer.isUnsubscribed()) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            observer.onNext(i);
                            if (i == 3) {
                                throw new RuntimeException("num is illegal");
                            }
                        } catch (Exception e) {
                            // 错误用法: for 循环中调用 onError 执行完 onError 后不再继续执行了剩余的 onNext 了
                            observer.onError(e);
                        }
                    }
                    observer.onCompleted();
                }
            }
        })
        .retry(3)
        .subscribe(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {
                System.out.println("observable finished...");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("observable execute exception: " + throwable);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("accept observable response: " + integer);
            }
        });
    }
}
