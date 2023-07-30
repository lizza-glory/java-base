package com.lizza.operator.error;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @Desc: 从onError通知中恢复发射数据
 * @author: lizza.liu
 * @date: 2021-08-14
 */
public class Catch {

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
                .onErrorResumeNext(Observable.just(999))
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
