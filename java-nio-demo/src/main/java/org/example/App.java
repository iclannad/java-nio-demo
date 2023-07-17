package org.example;

import java.nio.IntBuffer;
import java.sql.Array;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 堆缓冲区，直接缓存区
        // buffer类缓冲区，类似于数组,用于存放和获取数据
        // buffer结构类似与golang的切片

        // buffer写数据
//        IntBuffer buffer = IntBuffer.allocate(2);
//        buffer.put(1);
//        buffer.put(2);
//        buffer.put(3);
//        System.out.println(Arrays.toString(buffer.array()));

        // buffer指定位置写数据
//        IntBuffer buffer = IntBuffer.allocate(3);
//        buffer.put(2,1);
//        buffer.put(4,1); // 越界
//        System.out.println(Arrays.toString(buffer.array()));

        // buffer使用源数组添加数据
//        int[] arr = new int[]{111,222,333};
//        IntBuffer buffer = IntBuffer.allocate(5);
//        buffer.put(99);
//        buffer.put(arr);
//        System.out.println(Arrays.toString(buffer.array()));

        // 指定数组部分写到buffer
//        int[] arr = new int[]{111,222,333};
//        IntBuffer buffer = IntBuffer.allocate(8);
//        buffer.put(arr,1,2);
//        System.out.println(Arrays.toString(buffer.array()));

        // 使用另一个buffer源创建新的buffer
//        IntBuffer src = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
//        IntBuffer buffer = IntBuffer.allocate(10);
//        buffer.put(src);
//        System.out.println(Arrays.toString(buffer.array()));

        // 支持链式调用
        IntBuffer buffer = IntBuffer.allocate(8);
        buffer.put(1).put(2).put(3).put(4).put(5);
        System.out.println(Arrays.toString(buffer.array()));

        // 缓冲区剩余位置
        System.out.println(buffer.remaining());

    }
}
