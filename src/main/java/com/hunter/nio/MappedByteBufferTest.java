package com.hunter.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: 内存映射文件
 * @author: hunter.yang
 * @date: 20201125 13:49
 */
public class MappedByteBufferTest {

    public static void main(String[] argv) throws IOException {

        boolean writer = false;
        String filename;
        if(argv.length != 2) {
            System.out.println("Usage: [ -r | -w ] filename");
            return;
        }
        writer = "-w".equals(argv[0]);
        filename = argv[1];

        RandomAccessFile raf = new RandomAccessFile(filename,(writer) ? "rw" : "r");
        FileChannel fc = raf.getChannel();

        // 部分使用
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 100, 200);

        // 读取全部
        MappedByteBuffer bufferAll = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        // private （copy-on-write） 只有当前实例能看到
        MappedByteBuffer bufferPrivate = fc.map(FileChannel.MapMode.PRIVATE, 0, fc.size());

        System.out.println(buffer.isReadOnly());


    }

}
