package com.lizza.file.zip;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.junit.Test;

import java.io.File;

/**
 *
 */
public class ZipPwd {

    @Test
    public void test1() throws Exception {
        try {
            //创建压缩文件
            ZipFile zipFile = new ZipFile("/Users/moka/Desktop/test.zip", "123".toCharArray());

            //设置压缩文件参数
            ZipParameters parameters = new ZipParameters();
            //设置压缩方法
            parameters.setCompressionMethod(CompressionMethod.DEFLATE);

            //设置压缩级别chu
            parameters.setCompressionLevel(CompressionLevel.NORMAL);

            //设置压缩文件加密
            parameters.setEncryptFiles(true);

            //设置加密方法
            parameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);

            //设置aes加密强度
            parameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_128);

            //添加文件到压缩文件
            zipFile.addFolder(new File("/Users/moka/Desktop/files"), parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
