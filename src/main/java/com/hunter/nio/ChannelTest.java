package com.hunter.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.*;

/**
 * @description: 通道基础
 * @author: hunter.yang
 * @date: 20201118 13:42
 */
public class ChannelTest {

    Channel channel = new Channel() {
        @Override
        public boolean isOpen() {
            return true;
        }

        @Override
        public void close() throws IOException {

        }
    };

    public static void main(String[] args) throws Exception{
        SocketChannel sc = SocketChannel.open( );
        sc.connect (new InetSocketAddress ("somehost", 1000));
        ServerSocketChannel ssc = ServerSocketChannel.open( );
        ssc.socket( ).bind (new InetSocketAddress(1000));
        DatagramChannel dc = DatagramChannel.open( );
        RandomAccessFile raf = new RandomAccessFile ("somefile", "r");
        FileChannel fc = raf.getChannel( );
    }
}
