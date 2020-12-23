package com.hunter.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 通道复制
 * @date 2020/11/18 23:53
 */
public class ChannelCopyTest {

    public static void main(String[] args) throws IOException{

        ReadableByteChannel source = Channels.newChannel(System.in);

        WritableByteChannel dest = Channels.newChannel(System.out);

        channelCopy1(source, dest);
        // alternatively， call channelCopy2 (source, dest);

        source.close();

        dest.close();

    }

    private static void channelCopy1 (ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
            buffer.flip();

            dest.write(buffer);
        }
    }

    private static void channelCopy2 (ReadableByteChannel src, WritableByteChannel dest) throws IOException{

        ByteBuffer buffer = ByteBuffer.allocateDirect(16*1024);

        while (src.read(buffer) != -1) {
            // 也就是说调用flip之后，读写指针指到缓存头部，并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
            buffer.flip();
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear();
        }

    }

}
