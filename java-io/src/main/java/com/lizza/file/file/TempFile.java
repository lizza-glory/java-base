package com.lizza.file.file;

import org.junit.Test;

import java.io.File;

public class TempFile {

    @Test
    public void test1() throws Exception {
        File tempFile = File.createTempFile("abc", "tmp", new File("."));
        tempFile.deleteOnExit();
    }

    @Test
    public void test3() throws Exception {
        File.createTempFile("abc", "tmp");
    }
}
