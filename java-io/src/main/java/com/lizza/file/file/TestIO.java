package com.lizza.file.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-12
 */
public class TestIO {

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    while(true) {
                        FileWriter writer = new FileWriter("./test", true);
                        writer.write("a");
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "t-" + i).start();
        }
    }
}
