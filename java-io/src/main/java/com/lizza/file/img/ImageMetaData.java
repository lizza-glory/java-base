package com.lizza.file.img;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.util.Collection;

/**
 * 提取照片中的元数据
 */
public class ImageMetaData {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/moka/Downloads/WechatIMG126.jpeg");
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        System.out.println("---打印全部详情---");
        //获取所有目录
        Iterable<Directory> directories = metadata.getDirectories();
        for (Directory directory : directories) {
            System.err.println("目录名："+directory.getName());
            //目录下的所有标签
            Collection<Tag> tags = directory.getTags();
            for (Tag tag : tags) {
                int tagType = tag.getTagType();
                String tagName = tag.getTagName();
                String description = tag.getDescription();
                System.out.format("标签类型：%d=====标签名:%s====描述：%s\n",tagType,tagName,description);
            }
            System.err.println("*************************************");
        }
    }
}
