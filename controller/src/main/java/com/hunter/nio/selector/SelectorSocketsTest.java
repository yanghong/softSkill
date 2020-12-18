package com.hunter.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 使用select() 为多个通道提供服务
 * @date 2020/12/14 19:12
 */
public class SelectorSocketsTest {

    public static int PORT_NUMBER =  1234;

    public static void main(String[] args) throws Exception{
        new SelectorSocketsTest().go(args);
    }

    public void go(String[] args) throws Exception {
        int port = PORT_NUMBER;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Listening on port" + port);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();

        Selector selector = Selector.open();

        serverSocket.bind(new InetSocketAddress(port));

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int n = selector.select();

            if (n == 0) {
                continue;
            }

            Iterator it = selector.selectedKeys().iterator();

            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    sayHello(channel);
                }

                if (key.isReadable()) {
                    readDataFromSocket(key);
                }

                it.remove();
            }
        }
    }

    protected void registerChannel(Selector selector, SelectableChannel channel, int ops) throws Exception{
        if (channel == null){
            return;
        }

        channel.configureBlocking(false);

        channel.register(selector, ops);
    }

    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    protected void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        int count;

        buffer.clear();

        while((count = socketChannel.read(buffer)) > 0) {
            // make buffer readable
            buffer.flip();

            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);

                buffer.clear();
            }

            if (count < 0) {
                socketChannel.close();
            }
        }
    }

    private void sayHello(SocketChannel channel) throws Exception {
        buffer.clear();
        buffer.put("Hi there!\r\n".getBytes());
        buffer.flip();

        channel.write(buffer);
    }
}
