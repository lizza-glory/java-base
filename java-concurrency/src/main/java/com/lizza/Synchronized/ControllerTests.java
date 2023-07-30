package com.lizza.Synchronized;

public class ControllerTests {

    public static void main(String[] args) {
        Controller controller = new Controller();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                controller.func1();
                controller.func2();
            }, "thread-" + i).start();
        }
    }
}
