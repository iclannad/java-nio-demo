package org.example;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * Hello world!
 */
public class ReadApp {
    public static void main(String[] args) {
        // buffer读操作,依次读操作
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        IntBuffer buffer = IntBuffer.wrap(arr);
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        System.out.println(buffer.position());
//        System.out.println(buffer.get()); // 读越界

        // buffer读操作,指定读
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        IntBuffer buffer = IntBuffer.wrap(arr);
//        System.out.println(buffer.get(2));
//        System.out.println(buffer.position()); // 不影响position

        // buffer读数据到数组中
//        int[] dst = new int[2];
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        IntBuffer buffer = IntBuffer.wrap(arr);
//        buffer.get(dst);  // 读到dst
//        System.out.println(buffer.position()); // 影响position
//        System.out.println(Arrays.toString(dst));

        int[] dst = new int[10];
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntBuffer buffer = IntBuffer.wrap(arr);
        buffer.get(dst,3,5);  // 读到dst,限定读取长度,3数据指定位置开始写数据
        System.out.println(buffer.position()); // 影响position
        System.out.println(Arrays.toString(dst));



    }
}
