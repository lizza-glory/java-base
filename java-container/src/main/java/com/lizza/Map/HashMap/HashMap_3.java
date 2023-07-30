package com.lizza.Map.HashMap;

/**
 * 验证
 * 1. 当 table 长度为 2n 时, hashCode % length = hashCode & (length - 1)
 * 2. 高位为什么要参与运算: length 较小时, hashCode 较大, 降低 Hash 碰撞
 */
public class HashMap_3 {

    public static void main(String[] args){
        // 验证 当 table 长度为 2n 时, hashCode % length = hashCode & (length - 1)
    	int length = 16;
    	int hashCode = "lizza的手机".hashCode();
    	System.out.println("hashCode: " + hashCode);
    	System.out.println((hashCode % length) == (hashCode & (length - 1)));
    	// hashCode 写死
        hashCode = 7;
        System.out.println(hashCode % length);          // 结果: 7
        System.out.println(hashCode & (length - 1));    // 结果: 7

        // 验证 高位为什么要参与运算
        // 111100000
        int code1 = 2147418592;
        // 111000000
        int code2 = 448;
        // 110000000
        int code3 = 384;
        System.out.println("index: " + (code1 & (length - 1)));
        System.out.println("index: " + (code2 & (length - 1)));
        System.out.println("index: " + (code3 & (length - 1)));
        // 高位参与运算
        System.out.println("index: " + (code1 ^ (code1 >>> 16) & (length - 1)));
        System.out.println("index: " + (code2 ^ (code2 >>> 16) & (length - 1)));
        System.out.println("index: " + (code3 ^ (code3 >>> 16) & (length - 1)));
        System.out.println((2147418592 ^ (2147418592 >>> 16)) & 15);
        System.out.println(2147418592 & 15);
//        Map<Key, Object> map = new HashMap<>(16);
//        map.put(new Key(480), 480);
//        System.out.println(Integer.valueOf("01111111111111110000000111100000", 2));
        System.out.println(2 << 2);
    }

    static class Key {
        int value;
        public Key(int value) {
            this.value = value;
        }
        @Override
        public int hashCode() {
            return value;
        }
    }
}
