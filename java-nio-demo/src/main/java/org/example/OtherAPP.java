package org.example;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * 其它操作
 */
public class OtherAPP {
    public static void main(String[] args) {
        // compact
//        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
//        for (int i = 0; i < 4; i++) {
//            buffer.get();
//        }
//        buffer.compact();   // 压缩缓存区
//
//        System.out.println("压缩之后的情况：" + Arrays.toString(buffer.array()));
//        System.out.println("当前position位置：" + buffer.position());
//        System.out.println("当前limit位置:" + buffer.limit());


        // duplicate: 复制缓冲区，修改复制的缓存区会影响到原来缓冲区的数据
//        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
//        for (int i = 0; i < 4; i++) {
//            buffer.get();
//        }
//        buffer.compact();   // 压缩缓存区
//        IntBuffer duplicate = buffer.duplicate();
//        System.out.println("duplicate==>" + Arrays.toString(duplicate.array()));

        // slice:
//        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
//        for (int i = 0; i < 4; i++) {
//            buffer.get();
//        }
//        IntBuffer slice = buffer.slice();
//        System.out.println("划分之后的情况：" + Arrays.toString(slice.array()));
//        System.out.println("划分之后的偏移地址：" + slice.arrayOffset());
//        System.out.println("当前position位置：" + slice.position());
//        System.out.println("当前limit的位置：" + slice.limit());
//
//        while (slice.hasRemaining()) { // 将所有的数据全部打印出来
//            System.out.print(slice.get() + ", ");
//        }


//        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
//        for (int i = 0; i < 4; i++) {
//            buffer.get();
//        }
//        buffer.put(55);
//        System.out.println("buffer：" + Arrays.toString(buffer.array()));
//        // flip: Flips this buffer. The limit is set to the current position and then the position is set to zero. If the mark is defined then it is discarded.
//        //  flip会改变limit的值，一般会设置为当前的读写位置；
//        buffer.flip();
//        while (buffer.hasRemaining()) {
//            System.out.print(buffer.get() + ", ");
//        }
//
//        // rewind:  rewind不会改变limit的值，一般会设置为capacity的值；
//        System.out.println("rewind1==>" + buffer.position());
//        buffer.rewind();
//        System.out.println("rewind2==>" + buffer.position());

        // clear: resets the limit to the capacity
//        System.out.println("clear1==>" + buffer.position());
//        buffer.clear();
//        System.out.println("clear2==>" + buffer.position());
//        System.out.println("clear2==>" + Arrays.toString(buffer.array()));


        // equals比较剩余数据
//        IntBuffer buffer1 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        IntBuffer buffer2 = IntBuffer.wrap(new int[]{6, 5, 4, 3, 2, 1, 7, 8, 9});
//        System.out.println(buffer1.equals(buffer2));
//
//        buffer1.position(6);
//        buffer2.position(6);
//        System.out.println(buffer1.equals(buffer2));


        // compareTo比较剩余数据
        IntBuffer buffer1 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        IntBuffer buffer2 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 9, 8, 7});
        System.out.println(buffer1.equals(buffer2));

        buffer1.position(6);
        buffer2.position(6);
        buffer1.flip();
        buffer2.flip();

        System.out.println(buffer1.compareTo(buffer2));

    }

}
