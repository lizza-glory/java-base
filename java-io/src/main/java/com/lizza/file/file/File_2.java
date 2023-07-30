package com.lizza.file.file;

import java.io.File;
import java.io.IOException;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-05
 */
public class File_2 {

    public static void main(String[] args) throws IOException {
        File file = new File("test");
        file.createNewFile();
    }
}
