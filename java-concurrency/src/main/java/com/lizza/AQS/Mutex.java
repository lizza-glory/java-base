package com.lizza.AQS;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 利用AQS实现不可重入的互斥锁
 * 1. state: 1: 表示当前线程拥有锁 0: 表示当前线程没有拥有锁
 * 2. 实现Lock接口和Serializable
 *
 */
public class Mutex implements Lock, Serializable {

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static class Sync extends AbstractQueuedLongSynchronizer {

        /**
         * 1. 利用CAS(Compare And Swap)操作去原子的更新state的值; 当state为0时, 说明锁被释放了
         */
        @Override
        protected boolean tryAcquire(long arg) {
            assert arg == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 将state的值更新为0: 释放锁
         */
        @Override
        protected boolean tryRelease(long arg) {
            assert arg == 1;
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 如果同步器是当前线程独占, 则返回true
         */
        @Override
        protected boolean isHeldExclusively() {
            return super.getState() == 1;
        }
    }
}
