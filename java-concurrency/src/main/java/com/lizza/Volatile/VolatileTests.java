package com.lizza.Volatile;

/**
 * -XX:+PrintCommandLineFlags   打印 JVM 启动参数
 * -Xint                        开启解释模式
 */
public class VolatileTests {

    private boolean flag = false;

    public static void main(String[] args) throws Exception {
        VolatileTests obj = new VolatileTests();
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.flag = true;
            System.out.println("flagB is changed");
        }, "thread-a").start();
        // -Xint 开启解释模式, 则不会编译优化, flag 的改变会被线程 A 识别到, 即会打印 end
        // 如果不加, 则会死循环
        while (!obj.flag) {
//            System.out.println("flagB is false");
        }
        System.out.println("test2 is finished!");
    }
}
