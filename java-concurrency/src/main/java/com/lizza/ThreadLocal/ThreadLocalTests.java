package com.lizza.ThreadLocal;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lt
 * @version v1.0
 * @date 2019年5月19日
 */
public class ThreadLocalTests {

    /**
     * ThreadLocal 基本使用
     */
    @Test
    public void test1() throws Exception {
        ThreadLocal<String> name = new ThreadLocal<>();
        ThreadLocal<Integer> age = new ThreadLocal<>();
        Thread t1 = new Thread(() -> {
            name.set("李华");
            //只能获取当前线程set的值
            System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
            //输出为null
            System.out.println(Thread.currentThread().getName() + ", age: " + age.get());
        }, "线程1");
        Thread t2 = new Thread(() -> {
            name.set("王五");
            age.set(23);
            //输出为null
            System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
            //只能获取当前线程set的值
            System.out.println(Thread.currentThread().getName() + ", age: " + age.get());
        }, "线程2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
    }

    /**
     * SimpleDataFormat 线程不安全问题
     * 内部有成员变量 Calendar, 涉及写操作, 多个线程并发操作会出现问题, 主要是抛出异常
     */
    @Test
    public void test2() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    System.out.println(format.parse("2022-07-24"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    /**
     * 复现 ThreadLocal 内存泄漏问题
     * 内存 20MB, 新老各一半
     * 线程池, 15 个核心线程, 每个线程在 ThreadLocal 中塞 1MB
     * 调用 remove: 不会 OOM
     * 不调用 remove: 会 OOM
     -XX:+PrintCommandLineFlags
     -XX:+PrintFlagsFinal
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -XX:+PrintGCApplicationStoppedTime
     -XX:+PrintGCApplicationConcurrentTime
     -XX:+PrintHeapAtGC
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xloggc:/Users/lizza/Desktop/gc.log
     -Xms20m
     -Xmx20m
     -Xmn10m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     */
    @Test
    public void test3() throws Exception {
		ThreadLocal<byte[]> local = new ThreadLocal<>();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                try {
                    local.set(new byte[1024 * 1024]);
                } finally {
                    // get 只有在查询不到时, 才会去进行清理动作
					local.get();
//					local.remove();
                }
            });
        }
        executor.shutdown();
    }

}
