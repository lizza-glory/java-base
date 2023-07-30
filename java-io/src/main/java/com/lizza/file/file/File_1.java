package com.lizza.file.file;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-03-22
 */
public class File_1 {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/admin/Desktop/20210319.log");
        FileInputStream is = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str;
        List<String> list = Lists.newArrayList();
        while(StrUtil.isNotBlank(str = reader.readLine())) {
            list.add(str);
        }
        Map<String, List<String>> map = screenManufacturer(list, false);
        map.entrySet().forEach(System.out::println);
        is.close();
        reader.close();
    }

    public static String getFullSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                String[] strings = null;
                try {
                    strings = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (strings == null || strings.length <= 0) {
                        continue;
                    }
                    pybf.append(strings[0]);
                } catch (Exception e) {
                    System.out.println("获取全拼失败: " + Arrays.toString(strings));
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString();
    }

    public static Map<String, List<String>> screenManufacturer(List<String> list, boolean all) {
        try {
            Collator com = Collator.getInstance(Locale.CHINA);
            // 按字母排序
            list.sort(com);
            // 输出26个字母
            TreeMap<String, List<String>> map = new TreeMap<>();
            Set<String> set = Sets.newHashSet();
            for (int i = 1; i < 27; i++) {
                String word = String.valueOf((char)(96 + i)).toUpperCase();
                // 循环找出 首字母一样的数据
                List<String> letter = new ArrayList<>();
                for (String str : list) {
                    try {
                        String bf = getFullSpell(str.substring(0, 1));
                        if (bf.length() == 0) {
                            set.add(str);
                            continue;
                        }
                        String zm = bf.substring(0, 1);
                        if (word.equals(zm)) {
                            letter.add(str);
                        }
                    } catch (Exception e) {
                        System.out.println("获取首字母失败: " + str);
                        e.printStackTrace();
                    }
                }
                if (all || !letter.isEmpty()) {
                    map.put(word, letter);
                }
            }
            if (set.size() > 0) {
                map.put("#", Lists.newArrayList(set));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("#", "3");
        System.out.println(JSONObject.toJSON(map));
    }
}
